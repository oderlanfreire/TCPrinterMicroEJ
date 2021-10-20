/**
 *
 */
package mainpack.scan;

import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.RectangularBackground;
import ej.mwt.style.dimension.FixedDimension;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;
import ej.mwt.stylesheet.selector.Selector;
import ej.widget.basic.ImageButton;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;
import mainprinter.Main;

/**
 * The Class ScanPhoto. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class ScanPhoto {

	/** The scan BTN. */
	static ImageButton scanBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The title LBL. */
	static Label titleLBL;

	/** The text 1 LBL. */
	static Label text1LBL;

	/** The text 2 LBL. */
	static Label text2LBL;

	/** The Constant titleSTR. */
	private static final String titleSTR = "SCAN PHOTO"; //$NON-NLS-1$

	/** The Constant text1STR. */
	private static final String text1STR = "Please lift the lid and place the photo"; //$NON-NLS-1$

	/** The Constant text2STR. */
	private static final String text2STR = "on the tray. Hit Scan when you're done"; //$NON-NLS-1$

	/** The Constant SCAN_BUTTON_IMG. */
	private static final String SCAN_BUTTON_IMG = "/images/BUTTON_SCAN.png"; //$NON-NLS-1$

	/** The Constant PREV_PAGE. */
	private static final String PREV_PAGE = "/images/home_seta.png";//$NON-NLS-1$

	/** The Constant HOME_PAGE. */
	private static final String HOME_PAGE = "/images/home.png"; //$NON-NLS-1$

	/** The Constant SCAN_BUTTON. */
	private static final int SCAN_BUTTON = 888;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 881;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 882;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 883;

	/** The Constant TEXT1_LABEL. */
	private static final int TEXT1_LABEL = 884;

	/** The Constant TEXT2_LABEL. */
	private static final int TEXT2_LABEL = 885;

	/** The Constant CANVAS. */
	private static final int CANVAS = 886;

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public void Actions() {
		scanBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanLoading load = new ScanLoading();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				load.populateStylesheet(stylesheet);
				load.setID(2);
				d.setStylesheet(stylesheet);
				d.setWidget(load.getContentWidget());
				d.requestShow();

			}
		});

		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Scan scan = new Scan();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				scan.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(scan.getContentWidget());
				d.requestRender();
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
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector scanBTNSel = new ClassSelector(SCAN_BUTTON);
		Selector backBTNSel = new ClassSelector(BACK_BUTTON);
		Selector homeBTNSel = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector text1LBLSel = new ClassSelector(TEXT1_LABEL);
		Selector text2LBLSel = new ClassSelector(TEXT2_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(scanBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(backBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(homeBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(titleLBLSel);
		style.setFont(font18);
		style.setColor(0xBF40BF);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(text1LBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(text2LBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		scanBTN = new ImageButton(SCAN_BUTTON_IMG);
		scanBTN.addClassSelector(SCAN_BUTTON);
		backBTN = new ImageButton(PREV_PAGE);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_PAGE);
		homeBTN.addClassSelector(HOME_BUTTON);
		titleLBL = new Label(titleSTR);
		titleLBL.addClassSelector(TITLE_LABEL);
		text1LBL = new Label(text1STR);
		text1LBL.addClassSelector(TEXT1_LABEL);
		text2LBL = new Label(text2STR);
		text2LBL.addClassSelector(TEXT2_LABEL);
		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(titleLBL, 145, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text1LBL, 70, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text2LBL, 68, 75, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(scanBTN, 150, 180, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;

	}
}
