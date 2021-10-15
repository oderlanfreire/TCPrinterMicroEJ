/**
 *
 */
package mainprinter;

import java.util.Calendar;

import ej.microui.MicroUI;
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
import ej.widget.basic.ImageWidget;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;
import mainpack.copy.Copy;
import mainpack.print.Printer;
import mainpack.scan.Scan;

/**
 * The Class Main. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class Main {

	/** The scan BTN. */
	static ImageButton scanBTN;

	/** The print BTN. */
	static ImageButton printBTN;

	/** The copy BTN. */
	static ImageButton copyBTN;

	/** The wifi BTN. */
	static ImageButton wifiBTN;

	/** The conf BTN. */
	static ImageButton confBTN;

	/** The text LBL 1. */
	static Label textLBL1;

	/** The text LBL 2. */
	static Label textLBL2;

	/** The hour. */
	static Label hour;

	/** The date. */
	static Label date;

	/** The clock. */
	static ImageWidget clock;

	/** The ink. */
	static ImageWidget ink;

	/** The calendar. */
	static Calendar calendar;

	/** The weekday. */
	static String weekday;

	/** The Constant textSTR1. */
	private static final String textSTR1 = "Hello, What do you"; //$NON-NLS-1$

	/** The Constant textSTR2. */
	private static final String textSTR2 = "need to do?"; //$NON-NLS-1$

	/** The Constant SCAN_ID. */
	private static final int SCAN_ID = 1;

	/** The Constant PRINT_ID. */
	private static final int PRINT_ID = 2;

	/** The Constant COPY_ID. */
	private static final int COPY_ID = 3;

	/** The Constant WIFI_ID. */
	private static final int WIFI_ID = 4;

	/** The Constant CONFIG_ID. */
	private static final int CONFIG_ID = 5;

	/** The Constant TEXT_ID1. */
	private static final int TEXT_ID1 = 6;

	/** The Constant TEXT_ID2. */
	private static final int TEXT_ID2 = 7;

	/** The Constant CANVAS. */
	private static final int CANVAS = 8;

	/** The Constant DATETIME. */
	private static final int DATETIME = 9;

	/** The Constant LEVELS. */
	private static final int LEVELS = 10;

	/** The Constant HOUR. */
	private static final int HOUR = 11;

	/** The Constant DATE. */
	private static final int DATE = 12;

	/**
	 * Set actions to the buttons using onClickListener. Make the navigation between the screens.
	 */
	public static void Actions() {
		scanBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Scan scan = new Scan();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				scan.setID(1);
				scan.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(scan.getContentWidget());
				d.requestRender();
				d.requestShow();
			}
		});

		printBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Printer printer = new Printer();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				printer.populateStylesheet(stylesheet);
				printer.setID(1);
				d.setStylesheet(stylesheet);
				d.setWidget(printer.getContentWidget());
				d.requestRender();
				d.requestShow();

			}
		});

		copyBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Copy copy = new Copy();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				copy.setID(1);
				copy.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(copy.getContentWidget());
				d.requestShow();
			}
		});
	}

	/**
	 * Create a selector, receive.
	 *
	 * @param stylesheet
	 *            populating the style of the code
	 */
	public static void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector scanBTNSel = new ClassSelector(SCAN_ID);
		Selector printBTNSel = new ClassSelector(PRINT_ID);
		Selector copyBTNSel = new ClassSelector(COPY_ID);
		Selector wifiBTNSel = new ClassSelector(WIFI_ID);
		Selector confBTNSel = new ClassSelector(CONFIG_ID);
		Selector textLBL1Sel = new ClassSelector(TEXT_ID1);
		Selector textLBL2Sel = new ClassSelector(TEXT_ID2);
		Selector canvasSel = new ClassSelector(CANVAS);
		Selector clockSel = new ClassSelector(DATETIME);
		Selector inkSel = new ClassSelector(LEVELS);
		Selector hourSel = new ClassSelector(HOUR);
		Selector dateSel = new ClassSelector(DATE);

		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$
		Font font8 = Font.getFont("/Fonts/ARIAL_BOLD_8PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(scanBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(clockSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(inkSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(printBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(copyBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(wifiBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(confBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(textLBL1Sel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(textLBL2Sel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(hourSel);
		style.setFont(font8);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xD3D3D3));

		style = stylesheet.getSelectorStyle(dateSel);
		style.setFont(font8);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xD3D3D3));
	}

	/**
	 * The main is where the MicroUi start and the code methods are called.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		MicroUI.start();
		Desktop d = new Desktop();

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		d.setWidget(getContentWidget());
		d.setStylesheet(stylesheet);
		d.requestShow();

	}

	/**
	 * Set the content of the widget. instance the content, add the the ID to the content, instance the Actions method
	 *
	 * @return canvas
	 *
	 */
	@SuppressWarnings("static-access")
	public static Widget getContentWidget() {

		scanBTN = new ImageButton("/images/BSCAN.png"); //$NON-NLS-1$
		scanBTN.addClassSelector(SCAN_ID);
		printBTN = new ImageButton("/images/PRINT.png"); //$NON-NLS-1$
		printBTN.addClassSelector(PRINT_ID);
		copyBTN = new ImageButton("/images/COPY.png"); //$NON-NLS-1$
		copyBTN.addClassSelector(COPY_ID);
		wifiBTN = new ImageButton("/images/home_wifi.png"); //$NON-NLS-1$
		wifiBTN.addClassSelector(WIFI_ID);
		confBTN = new ImageButton("/images/home_config.png"); //$NON-NLS-1$
		confBTN.addClassSelector(CONFIG_ID);
		textLBL1 = new Label(textSTR1);
		textLBL1.addClassSelector(TEXT_ID1);
		textLBL2 = new Label(textSTR2);
		textLBL2.addClassSelector(TEXT_ID2);
		clock = new ImageWidget("/images/home_fundohorario_data.png"); //$NON-NLS-1$
		clock.addClassSelector(DATETIME);
		ink = new ImageWidget("/images/LEVEL.png"); //$NON-NLS-1$
		ink.addClassSelector(LEVELS);
		calendar = Calendar.getInstance();
		hour = new Label(Integer.toString(calendar.get(calendar.HOUR_OF_DAY)) + " : " //$NON-NLS-1$
				+ Integer.toString(calendar.get(calendar.MINUTE)));
		hour.addClassSelector(HOUR);
		date = new Label(Integer.toString(calendar.get(calendar.DAY_OF_MONTH)) + "/" //$NON-NLS-1$
				+ Integer.toString(calendar.get(calendar.MONTH)) + "/" //$NON-NLS-1$
				+ Integer.toString(calendar.get(calendar.SHORT)));
		date.addClassSelector(DATE);

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		Actions();

		cv.addChild(textLBL1, 10, 5, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL2, 10, 25, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(ink, 10, 230, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(clock, 330, 5, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(scanBTN, 20, 70, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(printBTN, 165, 70, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(copyBTN, 315, 70, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(hour, 345, 15, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(date, 400, 15, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		cv.addChild(wifiBTN, 350, 230, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(confBTN, 400, 230, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;

	}
}
