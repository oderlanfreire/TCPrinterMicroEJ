/**
 *
 */
package mainpack.copy;

import ej.bon.XMath;
import ej.drawing.ShapePainter;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.style.Style;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.util.Size;

/**
 * The Class CircularProgress. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class CircularProgress extends Widget {

	/** The Constant START_ANGLE. */
	private static final int START_ANGLE = 90;

	/** The Constant FULL_ANGLE. */
	private static final int FULL_ANGLE = 360;

	/** The Constant DEFAULT_DIAMETER. */
	private static final int DEFAULT_DIAMETER = 100;

	/** The Constant DEFAULT_THICK. */
	private static final int DEFAULT_THICK = 5;

	/**
	 * Background color ID.
	 */
	public static final int BACKGROUND_COLOR = 0;
	/**
	 * Progress diameter ID.
	 */
	public static final int PROGRESS_DIAMETER = 1;
	/**
	 * Progress thick ID.
	 */
	public static final int PROGRESS_THICK = 2;

	/** The progress. */
	private float progress;

	/**
	 * Set progress between 0.0 and 1.0.
	 *
	 * @param progress
	 *            bar progress
	 */
	public void setProgress(float progress) {
		this.progress = XMath.limit(progress, 0.0f, 1.0f);
		requestRender();
		if (this.progress == 1.0f) {
			CopyFinishing cFin = new CopyFinishing();
			Desktop d = new Desktop();
			CascadingStylesheet stylesheet = new CascadingStylesheet();
			cFin.populateStylesheet(stylesheet);
			d.setStylesheet(stylesheet);
			d.setWidget(cFin.getContentWidget());
			d.requestShow();
		}
	}

	/**
	 * Compute content optimal size.
	 *
	 * @param size
	 *            the size
	 */
	@Override
	protected void computeContentOptimalSize(Size size) {
		Style style = getStyle();
		int diameter = style.getExtraInt(PROGRESS_DIAMETER, DEFAULT_DIAMETER);
		size.setSize(diameter, diameter);
	}

	/**
	 * Render content.
	 *
	 * @param g
	 *            the g
	 * @param contentWidth
	 *            the content width
	 * @param contentHeight
	 *            the content height
	 */
	@Override
	protected void renderContent(GraphicsContext g, int contentWidth, int contentHeight) {
		Style style = getStyle();
		int diameter = style.getExtraInt(PROGRESS_DIAMETER, DEFAULT_DIAMETER);
		int thick = style.getExtraInt(PROGRESS_THICK, DEFAULT_THICK);
		int progressDiameter = diameter - (thick << 2);

		// background
		g.setColor(style.getExtraInt(BACKGROUND_COLOR, Colors.BLACK));
		Painter.fillCircle(g, 0, 0, diameter);
		// Fills the complete part, from 90?? anti-clockwise.
		int startAngle;
		int arcAngle;

		arcAngle = (int) (-FULL_ANGLE * this.progress);
		startAngle = START_ANGLE;
		// progress
		int position = (thick << 1);
		g.setColor(style.getColor());
		ShapePainter.drawThickFadedCircleArc(g, position, position, progressDiameter, startAngle, arcAngle, thick, 1,
				ShapePainter.Cap.ROUNDED, ShapePainter.Cap.ROUNDED);
	}

}
