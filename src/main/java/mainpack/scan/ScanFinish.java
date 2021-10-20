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
 * The Class ScanFinish. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class ScanFinish {

	/** The done BTN. */
	static ImageButton doneBTN;

	/** The new scan BTN. */
	static ImageButton newScanBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The title LBL. */
	static Label titleLBL;

	/** The text LBL. */
	static Label textLBL;

	/** The Constant titleSTR. */
	private static final String titleSTR = "FINISH"; //$NON-NLS-1$

	/** The Constant textSTR. */
	private static final String textSTR = "You're all set! What's next?"; //$NON-NLS-1$

	/** The Constant DONE_BTN. */
	private static final String DONE_BTN = "/images/DONE.png"; //$NON-NLS-1$

	/** The Constant OTHERSCAN_BTN. */
	private static final String OTHERSCAN_BTN = "/images/OTHER_SCAN.png"; //$NON-NLS-1$

	/** The Constant BACK_BTN. */
	private static final String BACK_BTN = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BTN. */
	private static final String HOME_BTN = "/images/home.png"; //$NON-NLS-1$

	/** The Constant DONE_BUTTON. */
	private static final int DONE_BUTTON = 1234;

	/** The Constant SCAN_BUTTON. */
	private static final int SCAN_BUTTON = 1235;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 1236;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 1237;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 1238;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 1239;

	/** The Constant CANVAS. */
	private static final int CANVAS = 1240;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector doneBTNSel = new ClassSelector(DONE_BUTTON);
		Selector scanBTNSel = new ClassSelector(SCAN_BUTTON);
		Selector backBTNSel = new ClassSelector(BACK_BUTTON);
		Selector homeBTNSel = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(doneBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(scanBTNSel);
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

		style = stylesheet.getSelectorStyle(textLBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));

	}

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public void Actions() {
		doneBTN.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("static-access")
			@Override
			public void onClick() {
				Main main = new Main();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				main.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(main.getContentWidget());
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
				d.requestShow();
			}
		});

		newScanBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Scan scan = new Scan();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				scan.setID(2);
				scan.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(scan.getContentWidget());
				d.requestRender();
				d.requestShow();
			}
		});
		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanSave sSave = new ScanSave();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				sSave.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(sSave.getContentWidget());
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
		doneBTN = new ImageButton(DONE_BTN);
		doneBTN.addClassSelector(DONE_BUTTON);
		newScanBTN = new ImageButton(OTHERSCAN_BTN);
		newScanBTN.addClassSelector(SCAN_BUTTON);
		backBTN = new ImageButton(BACK_BTN);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_BTN);
		homeBTN.addClassSelector(HOME_BUTTON);
		titleLBL = new Label(titleSTR);
		titleLBL.addClassSelector(TITLE_LABEL);
		textLBL = new Label(textSTR);
		textLBL.addClassSelector(TEXT_LABEL);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(titleLBL, 180, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL, 130, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(doneBTN, 70, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(newScanBTN, 240, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;
	}
}
