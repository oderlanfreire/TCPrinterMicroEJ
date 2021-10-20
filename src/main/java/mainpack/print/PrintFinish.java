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
 * The Class PrintFinish. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class PrintFinish {

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The done BTN. */
	static ImageButton doneBTN;

	/** The new print BTN. */
	static ImageButton newPrintBTN;

	/** The title. */
	static Label title;

	/** The text. */
	static Label text;

	/** The Constant titText. */
	private static final String titText = "FINISHING"; //$NON-NLS-1$

	/** The Constant txtText. */
	private static final String txtText = "You're all set! What's next?";//$NON-NLS-1$

	/** The Constant DONE_BTN. */
	private static final String DONE_BTN = "/images/doneb.png"; //$NON-NLS-1$

	/** The Constant HOME_BTN. */
	private static final String HOME_BTN = "/images/home.png"; //$NON-NLS-1$

	/** The Constant BACK_BTN. */
	private static final String BACK_BTN = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant NEWPRINT_BTN. */
	private static final String NEWPRINT_BTN = "/images/reprint.png"; //$NON-NLS-1$

	/** The Constant PRINT_BUTTON. */
	private static final int PRINT_BUTTON = 21;

	/** The Constant DONE_BUTTON. */
	private static final int DONE_BUTTON = 22;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 23;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 24;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 666;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 777;

	/** The Constant CANVAS. */
	private static final int CANVAS = 888;

	/**
	 * populateStyleSheet, create a selector, receive the content ID.
	 *
	 * @param stylesheet
	 *            populating the style of the code
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector printSelBTN = new ClassSelector(PRINT_BUTTON);
		Selector dnSelBTN = new ClassSelector(DONE_BUTTON);
		Selector bckSelBTN = new ClassSelector(BACK_BUTTON);
		Selector hmSelBTN = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(printSelBTN);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(dnSelBTN);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(bckSelBTN);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(hmSelBTN);
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

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * Set actions to the buttons, make the navigation between the screens.
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

		newPrintBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Printer printer = new Printer();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				printer.populateStylesheet(stylesheet);
				printer.setID(2);
				d.setStylesheet(stylesheet);
				d.setWidget(printer.getContentWidget());
				d.requestRender();
				d.requestShow();
			}
		});

		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintLoading load = new PrintLoading();
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
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		doneBTN = new ImageButton(DONE_BTN);
		doneBTN.addClassSelector(DONE_BUTTON);
		newPrintBTN = new ImageButton(NEWPRINT_BTN);
		newPrintBTN.addClassSelector(PRINT_BUTTON);
		backBTN = new ImageButton(BACK_BTN);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME_BTN);
		homeBTN.addClassSelector(HOME_BUTTON);
		title = new Label(titText);
		title.addClassSelector(TITLE_LABEL);
		text = new Label(txtText);
		text.addClassSelector(TEXT_LABEL);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(title, 170, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text, 140, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(doneBTN, 50, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(newPrintBTN, 250, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;

	}
}
