/**
 *
 */
package mainpack.print;

import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.microui.display.Image;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.animation.Animation;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.ImageBackground;
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
 * The Class PrintLoading, a class which create a widget to receive a Circular Progress bar from other class, set the
 * style of Circular Progress bar from other class and set in the screen.
 */
public class PrintLoading {

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The print load. */
	static Label printLoad;

	/** The animated circular. */
	AnimatedCircularProgress animatedCircular;

	/** The loading. */
	private final String loading = "Printing...";//$NON-NLS-1$

	/** The Constant BACK_BUTTON_IMG. */
	private static final String BACK_BUTTON_IMG = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BUTTON_IMG. */
	private static final String HOME_BUTTON_IMG = "/images/home.png"; //$NON-NLS-1$

	/** The Constant CIRCULAR_SIZE. */
	private static final int CIRCULAR_SIZE = 100;

	/** The Constant CIRCULAR_THICK. */
	private static final int CIRCULAR_THICK = 5;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 19;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 20;

	/** The Constant TITLELABEL. */
	private static final int TITLELABEL = 555;

	/** The Constant CANVAS. */
	private static final int CANVAS = 21;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes. This method is responsible for the style of the Circular Progress bar too.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector hmPBtn = new ClassSelector(HOME_BUTTON);
		Selector bckPBtn = new ClassSelector(BACK_BUTTON);
		Selector canvasSel = new ClassSelector(CANVAS);
		Selector titleSelec = new ClassSelector(TITLELABEL);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(hmPBtn);
		style.setBackground(new ImageBackground(Image.getImage("/images/home.png"))); //$NON-NLS-1$

		style = stylesheet.getSelectorStyle(bckPBtn);
		style.setBackground(new ImageBackground(Image.getImage("/images/home_seta.png"))); //$NON-NLS-1$

		style = stylesheet.getSelectorStyle(titleSelec);
		style.setFont(font18);
		style.setColor(Colors.BLUE);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(new TypeSelector(CircularProgress.class));
		style.setColor(Colors.BLUE);
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
				PrintCopies pCopy = new PrintCopies();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				pCopy.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(pCopy.getContentWidget());
				d.requestShow();
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
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen. Create a stylesheet and
	 * call the method to set the style of the widget. Call the method to set actions to the buttons. Call a static
	 * class responsible for the animation of the Circular Progress bar.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		backBTN = new ImageButton(BACK_BUTTON_IMG);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_BUTTON_IMG);
		homeBTN.addClassSelector(HOME_BUTTON);
		printLoad = new Label(this.loading);
		printLoad.addClassSelector(TITLELABEL);

		this.animatedCircular = new AnimatedCircularProgress();

		Canvas cv = new Canvas();

		cv.addClassSelector(CANVAS);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(printLoad, 180, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(this.animatedCircular, 180, 100, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;
	}

	/**
	 * The Class AnimatedCircularProgress, it's a static class which create and control the animation of the Circular
	 * Progress bar and update the progress.
	 */
	private static class AnimatedCircularProgress extends CircularProgress implements Animation {

		/** The Constant ANIMATION_DURATION. */
		private static final int ANIMATION_DURATION = 5_000;

		/** The start time. */
		private long startTime;

		/**
		 * This method is responsible for start the animation. Get the current time of the system in milliseconds and
		 * set in the variable and set the variable at startAnimation called with getDesktop and get Animator.
		 */
		@Override
		protected void onShown() {
			this.startTime = System.currentTimeMillis();
			getDesktop().getAnimator().startAnimation(this);
		}

		/**
		 * This method is responsible for stop the animation when the next screen is called.
		 */
		@Override
		protected void onHidden() {
			getDesktop().getAnimator().stopAnimation(this);
		}

		/**
		 * This method is responsible for update the animation making the calculation using the current time and the
		 * value stored in the variable Set the progress and request the visual update in the screen with the render.
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
}
