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
 * The Class ScanSave. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class ScanSave {

	/** The s phone BTN. */
	static ImageButton sPhoneBTN;

	/** The s USBBTN. */
	static ImageButton sUSBBTN;

	/** The s computer BTN. */
	static ImageButton sComputerBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The title LBL. */
	static Label titleLBL;

	/** The text LBL. */
	static Label textLBL;

	/** The text 2 LBL. */
	static Label text2LBL;

	/** The Constant titleSTR. */
	private static final String titleSTR = "SEND / SAVE"; //$NON-NLS-1$

	/** The Constant textSTR. */
	private static final String textSTR = "What do you want to do with"; //$NON-NLS-1$

	/** The Constant text2STR. */
	private static final String text2STR = "your scan?"; //$NON-NLS-1$

	/** The Constant PHONE_BTN. */
	private static final String PHONE_BTN = "/images/PHONE.png"; //$NON-NLS-1$

	/** The Constant USB_BTN. */
	private static final String USB_BTN = "/images/usbp.png"; //$NON-NLS-1$

	/** The Constant PC_BTN. */
	private static final String PC_BTN = "/images/savepc.png"; //$NON-NLS-1$

	/** The Constant BACK_BTN. */
	private static final String BACK_BTN = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BTN. */
	private static final String HOME_BTN = "/images/home.png"; //$NON-NLS-1$

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 551;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 552;

	/** The Constant COMPUTER_BUTTON. */
	private static final int COMPUTER_BUTTON = 553;

	/** The Constant USB_BUTTON. */
	private static final int USB_BUTTON = 554;

	/** The Constant PHONE_BUTTON. */
	private static final int PHONE_BUTTON = 555;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 556;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 557;

	/** The Constant TEXT2_LABEL. */
	private static final int TEXT2_LABEL = 558;

	/** The Constant CANVAS. */
	private static final int CANVAS = 559;

	/**
	 * populateStyleSheet, create a selector, receive the content ID.
	 *
	 * @param stylesheet
	 *            populating the style of the code
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector phoneBTNSel = new ClassSelector(PHONE_BUTTON);
		Selector usbBTNSel = new ClassSelector(USB_BUTTON);
		Selector compBTNSel = new ClassSelector(COMPUTER_BUTTON);
		Selector backBTNSel = new ClassSelector(BACK_BUTTON);
		Selector homeBTNSel = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector text2LBLSel = new ClassSelector(TEXT2_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(phoneBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(usbBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(compBTNSel);
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

		style = stylesheet.getSelectorStyle(text2LBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * Set actions to the buttons, make the navigation between the screens.
	 */
	public void Actions() {
		sPhoneBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanFinish sFin = new ScanFinish();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				sFin.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(sFin.getContentWidget());
				d.requestShow();
			}
		});
		sUSBBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanFinish sFin = new ScanFinish();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				sFin.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(sFin.getContentWidget());
				d.requestShow();
			}
		});

		sComputerBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanFinish sFin = new ScanFinish();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				sFin.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(sFin.getContentWidget());
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

		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {

				ScanLoading load = new ScanLoading();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				load.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(load.getContentWidget());
				d.requestShow();
			}
		});
	}

	/**
	 * Set the content of the widget.
	 *
	 * @return the content widget
	 */
	public Widget getContentWidget() {
		sPhoneBTN = new ImageButton(PHONE_BTN);
		sPhoneBTN.addClassSelector(PHONE_BUTTON);
		sUSBBTN = new ImageButton(USB_BTN);
		sUSBBTN.addClassSelector(USB_BUTTON);
		sComputerBTN = new ImageButton(PC_BTN);
		sComputerBTN.addClassSelector(COMPUTER_BUTTON);
		backBTN = new ImageButton(BACK_BTN);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_BTN);
		homeBTN.addClassSelector(HOME_BUTTON);
		titleLBL = new Label(titleSTR);
		titleLBL.addClassSelector(TITLE_LABEL);
		textLBL = new Label(textSTR);
		textLBL.addClassSelector(TEXT_LABEL);
		text2LBL = new Label(text2STR);
		text2LBL.addClassSelector(TEXT2_LABEL);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(titleLBL, 170, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL, 120, 40, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text2LBL, 180, 70, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(sPhoneBTN, 20, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(sUSBBTN, 180, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(sComputerBTN, 340, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;
	}
}