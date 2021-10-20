/**
 *
 */
package mainpack.scan;

import ej.microui.display.Font;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.animation.Animation;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.RectangularBackground;
import ej.mwt.style.dimension.FixedDimension;
import ej.mwt.style.dimension.OptimalDimension;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;
import ej.mwt.stylesheet.selector.Selector;
import ej.mwt.stylesheet.selector.TypeSelector;
import ej.mwt.util.Alignment;
import ej.widget.basic.ImageButton;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;
import mainprinter.Main;

/**
 * The Class ScanLoading. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class ScanLoading {

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The scan load. */
	static Label scanLoad;

	/** The id. */
	private static int ID = 0;

	/** The animated circular. */
	AnimatedCircularProgress animatedCircular;

	/** The loading. */
	private final String loading = "Scanning...";//$NON-NLS-1$

	/** The Constant BACK_BUTTON_IMG. */
	private static final String BACK_BUTTON_IMG = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BUTTON_IMG. */
	private static final String HOME_BUTTON_IMG = "/images/home.png"; //$NON-NLS-1$

	/** The Constant CIRCULAR_SIZE. */
	private static final int CIRCULAR_SIZE = 100;

	/** The Constant CIRCULAR_THICK. */
	private static final int CIRCULAR_THICK = 5;

	/** The Constant BACK_ImageButton. */
	private static final int BACK_ImageButton = 19;

	/** The Constant HOME_ImageButton. */
	private static final int HOME_ImageButton = 20;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 555;

	/** The Constant CANVAS. */
	private static final int CANVAS = 21;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector hmPBtn = new ClassSelector(HOME_ImageButton);
		Selector bckPBtn = new ClassSelector(BACK_ImageButton);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(hmPBtn);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(bckPBtn);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(titleLBLSel);
		style.setFont(font18);
		style.setColor(0xBF40BF);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(new TypeSelector(CircularProgress.class));
		style.setColor(0xBF40BF);
		style.setExtraInt(CircularProgress.BACKGROUND_COLOR, 0xE5E5E0);
		style.setExtraInt(CircularProgress.PROGRESS_DIAMETER, CIRCULAR_SIZE);
		style.setExtraInt(CircularProgress.PROGRESS_THICK, CIRCULAR_THICK);
		style.setDimension(OptimalDimension.OPTIMAL_DIMENSION_XY);
		style.setHorizontalAlignment(Alignment.HCENTER);
		style.setVerticalAlignment(Alignment.VCENTER);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public static void Actions() {
		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				if (ID == 1) {
					ScanDoc doc = new ScanDoc();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					doc.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(doc.getContentWidget());
					d.requestShow();
				} else if (ID == 2) {
					ScanPhoto photo = new ScanPhoto();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					photo.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(photo.getContentWidget());
					d.requestShow();
				}
			}
		});

		homeBTN.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("static-access")
			@Override
			public void onClick() {
				Main main = new Main();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				main.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(main.getContentWidget());
				d.requestRender();
				d.requestShow();
			}
		});

	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		backBTN = new ImageButton(BACK_BUTTON_IMG);
		backBTN.addClassSelector(BACK_ImageButton);
		homeBTN = new ImageButton(HOME_BUTTON_IMG);
		homeBTN.addClassSelector(HOME_ImageButton);
		scanLoad = new Label(this.loading);
		scanLoad.addClassSelector(TITLE_LABEL);
		this.animatedCircular = new AnimatedCircularProgress();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(scanLoad, 180, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(this.animatedCircular, 180, 100, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;
	}

	/**
	 * This class is responsive for the phases and attributes of the animation.
	 */
	private static class AnimatedCircularProgress extends CircularProgress implements Animation {

		/** The Constant ANIMATION_DURATION. */
		private static final int ANIMATION_DURATION = 5_000;

		/** The start time. */
		private long startTime;

		/**
		 * This method is responsible for start the animation.
		 */
		@Override
		protected void onShown() {
			this.startTime = System.currentTimeMillis();
			getDesktop().getAnimator().startAnimation(this);
		}

		/**
		 * This method is responsible for stop the animation.
		 */
		@Override
		protected void onHidden() {
			getDesktop().getAnimator().stopAnimation(this);
		}

		/**
		 * This method is responsible for update the animation.
		 *
		 * @param currentTimeMillis
		 *            The current time in milliseconds.
		 * @return true, if successful
		 */
		@Override
		public boolean tick(long currentTimeMillis) {
			long elapsedTime = currentTimeMillis - this.startTime;
			setProgress(1.0f * elapsedTime / ANIMATION_DURATION);
			requestRender();
			return (elapsedTime < ANIMATION_DURATION);
		}
	}

	/**
	 * Gets the iD.
	 *
	 * @return the iD.
	 */
	public static int getID() {
		return ID;
	}

	/**
	 * Sets the iD to control what screen will turn back when click in the back button
	 *
	 * @param iD
	 *            the iD to set.
	 */
	public void setID(int iD) {
		ID = iD;
	}
}
