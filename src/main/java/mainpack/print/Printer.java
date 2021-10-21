/**
 *
 */
package mainpack.print;

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
 * The Class Printer. a class which create a widget that you can choice a source to seek the file that you want to
 * print.
 */
public class Printer {

	/** The phone BTN. */
	static ImageButton fPhoneBTN;

	/** The usb BTN. */
	static ImageButton fUsbBTN;

	/** The computer BTN. */
	static ImageButton fComputerBTN;

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

	/** The id. */
	private static int ID = 0;

	/** The title STR. */
	private final String titleSTR = "PRINT"; //$NON-NLS-1$

	/** The text STR. */
	private final String textSTR = "Please, select a"; //$NON-NLS-1$

	/** The text 2 STR. */
	private final String text2STR = "source to print:"; //$NON-NLS-1$

	/** The Constant FPHONE. */
	private static final String FPHONE = "/images/FROM_PHONE.png"; //$NON-NLS-1$

	/** The Constant FUSB. */
	private static final String FUSB = "/images/FROM_USB.png"; //$NON-NLS-1$

	/** The Constant FCOMPUTER. */
	private static final String FCOMPUTER = "/images/FROM_COMPUTER.png"; //$NON-NLS-1$

	/** The Constant BACK_BTN_IMG. */
	private static final String BACK_BTN_IMG = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BTN_IMG. */
	private static final String HOME_BTN_IMG = "/images/home.png"; //$NON-NLS-1$

	/** The Constant PHN_BUTTON. */
	private static final int PHN_BUTTON = 50;

	/** The Constant USB_BUTTON. */
	private static final int USB_BUTTON = 51;

	/** The Constant CPTR_BUTTON. */
	private static final int CPTR_BUTTON = 52;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 53;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 54;

	/** The Constant CANVAS. */
	private static final int CANVAS = 55;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 111;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 112;

	/** The Constant TEXT2_LABEL. */
	private static final int TEXT2_LABEL = 113;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector phoneBTNSel = new ClassSelector(PHN_BUTTON);
		Selector usbBTNSel = new ClassSelector(USB_BUTTON);
		Selector compBTNSel = new ClassSelector(CPTR_BUTTON);
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
		style.setColor(Colors.BLUE);
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
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public void Actions() {
		fPhoneBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintPhone phone = new PrintPhone();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				phone.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(phone.getContentWidget());
				d.requestShow();

			}
		});

		fUsbBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintUSB usb = new PrintUSB();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				usb.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(usb.getContentWidget());
				d.requestShow();

			}
		});

		fComputerBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintComputer pc = new PrintComputer();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				pc.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(pc.getContentWidget());
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

		backBTN.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("static-access")
			@Override
			public void onClick() {
				if (ID == 1) {
					Main main = new Main();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					main.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(main.getContentWidget());
					d.requestRender();
					d.requestShow();
				} else if (ID == 2) {
					PrintFinish pFin = new PrintFinish();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					pFin.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(pFin.getContentWidget());
					d.requestShow();
				}
			}
		});

	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen. Create a stylesheet and
	 * call the method to set the style of the widget. Call the method to set actions to the buttons.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		fPhoneBTN = new ImageButton(FPHONE);
		fPhoneBTN.addClassSelector(PHN_BUTTON);
		fUsbBTN = new ImageButton(FUSB);
		fUsbBTN.addClassSelector(USB_BUTTON);
		fComputerBTN = new ImageButton(FCOMPUTER);
		fComputerBTN.addClassSelector(CPTR_BUTTON);
		backBTN = new ImageButton(BACK_BTN_IMG);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_BTN_IMG);
		homeBTN.addClassSelector(HOME_BUTTON);
		titleLBL = new Label(this.titleSTR);
		titleLBL.addClassSelector(TITLE_LABEL);
		textLBL = new Label(this.textSTR);
		textLBL.addClassSelector(TEXT2_LABEL);
		text2LBL = new Label(this.text2STR);
		text2LBL.addClassSelector(TEXT2_LABEL);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(titleLBL, 170, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL, 150, 40, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text2LBL, 150, 60, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(fPhoneBTN, 20, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(fUsbBTN, 180, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(fComputerBTN, 340, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;

	}

	/**
	 * Gets the iD from the selected class.
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
