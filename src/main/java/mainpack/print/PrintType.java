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
 * The Class PrintType. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class PrintType {

	/** The color print. */
	static ImageButton colorPrint;

	/** The coloroff print. */
	static ImageButton coloroffPrint;

	/** The back. */
	static ImageButton back;

	/** The home. */
	static ImageButton home;

	/** The title. */
	static Label title;

	/** The text. */
	static Label text;

	/** The id. */
	private static int ID = 0;

	/** The Constant titleSTR. */
	private static final String titleSTR = "PRINT TYPE"; //$NON-NLS-1$

	/** The Constant textSTR. */
	private static final String textSTR = "Please select a source to print:"; //$NON-NLS-1$

	/** The Constant COLOR_BTN_IMG. */
	private static final String COLOR_BTN_IMG = "/images/printcolor.png"; //$NON-NLS-1$

	/** The Constant OFFCOLOR_BTN_IMG. */
	private static final String OFFCOLOR_BTN_IMG = "/images/printbw.png"; //$NON-NLS-1$

	/** The Constant BACK_BTN_IMG. */
	private static final String BACK_BTN_IMG = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME_BTN_IMG. */
	private static final String HOME_BTN_IMG = "/images/home.png"; //$NON-NLS-1$

	/** The Constant COLOR_BUTTON. */
	private static final int COLOR_BUTTON = 255;

	/** The Constant COLOR_OFF_BUTTON. */
	private static final int COLOR_OFF_BUTTON = 111;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 122;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 133;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 144;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 155;

	/** The Constant CANVAS. */
	private static final int CANVAS = 166;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector colorBTNSel = new ClassSelector(COLOR_BUTTON);
		Selector coloroffBTNSel = new ClassSelector(COLOR_OFF_BUTTON);
		Selector backBTNSel = new ClassSelector(BACK_BUTTON);
		Selector homeBTNSel = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(colorBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(coloroffBTNSel);
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
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(textLBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	static void Actions() {
		colorPrint.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintCopies pCopies = new PrintCopies();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				pCopies.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(pCopies.getContentWidget());
				d.requestShow();
			}
		});
		coloroffPrint.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintCopies pCopies = new PrintCopies();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				pCopies.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(pCopies.getContentWidget());
				d.requestShow();
			}
		});

		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				if (ID == 1) {
					PrintPhone pPhone = new PrintPhone();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					pPhone.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(pPhone.getContentWidget());
					d.requestShow();
				} else if (ID == 2) {
					PrintUSB pUSB = new PrintUSB();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					pUSB.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(pUSB.getContentWidget());
					d.requestShow();
				}
			}
		});

		home.setOnClickListener(new OnClickListener() {
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
	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		colorPrint = new ImageButton(COLOR_BTN_IMG);
		colorPrint.addClassSelector(COLOR_BUTTON);
		coloroffPrint = new ImageButton(OFFCOLOR_BTN_IMG);
		coloroffPrint.addClassSelector(COLOR_OFF_BUTTON);
		back = new ImageButton(BACK_BTN_IMG);
		back.addClassSelector(BACK_BUTTON);
		home = new ImageButton(HOME_BTN_IMG);
		home.addClassSelector(HOME_BUTTON);
		title = new Label(titleSTR);
		title.addClassSelector(TITLE_LABEL);
		text = new Label(textSTR);
		text.addClassSelector(TEXT_LABEL);

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		Actions();

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		cv.addChild(back, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(title, 150, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(home, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(colorPrint, 40, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(coloroffPrint, 240, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;
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
	 * Sets the iD to control what screen will turn back when click in the back button.
	 *
	 * @param iD
	 *            the iD to set.
	 */
	public void setID(int iD) {
		ID = iD;
	}
}
