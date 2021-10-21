/**
 *
 */
package mainpack.copy;

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
import mainprinter.Main;

/**
 * The Class CopyOption, a class which creates a widget that you can configure the amount of copies that the printer
 * will do.
 *
 */
public class CopyOption {

	/** The title LBL. */
	static Label titleLBL;

	/** The text LBL. */
	static Label textLBL;

	/** The count copy. */
	static Label countCopy;

	/** The c copy. */
	private static int cCopy = 4;

	/** The plus BTN. */
	static ImageButton plusBTN;

	/** The minus BTN. */
	static ImageButton minusBTN;

	/** The print BTN. */
	static ImageButton printBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The number back. */
	static ImageWidget numberBack;

	/** The Constant tltText. */
	private static final String tltText = "COPY OPTIONS"; //$NON-NLS-1$

	/** The Constant txtText. */
	private static final String txtText = "How many copies do you need?"; //$NON-NLS-1$

	/** The Constant NUM_IMG. */
	private static final String NUM_IMG = "/images/numberbackground.png";//$NON-NLS-1$

	/** The Constant PLUS. */
	private static final String PLUS = "/images/add.png"; //$NON-NLS-1$

	/** The Constant MINUS. */
	private static final String MINUS = "/images/minus.png"; //$NON-NLS-1$

	/** The Constant BACK. */
	private static final String BACK = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME. */
	private static final String HOME = "/images/home.png"; //$NON-NLS-1$

	/** The Constant PRINT. */
	private static final String PRINT = "/images/copyb.png"; //$NON-NLS-1$

	/** The Constant PLUS_BUTTON. */
	private static final int PLUS_BUTTON = 14;

	/** The Constant MINUS_BUTTON. */
	private static final int MINUS_BUTTON = 15;

	/** The Constant PRINT_BUTTON. */
	private static final int PRINT_BUTTON = 16;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 17;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 18;

	/** The Constant COUNT. */
	private static final int COUNT = 999;

	/** The Constant TITLE_LBL. */
	private static final int TITLE_LBL = 1010;

	/** The Constant TEXT_LBL. */
	private static final int TEXT_LBL = 1111;

	/** The Constant CANVAS. */
	private static final int CANVAS = 1212;

	/** The Constant NUM_BACK. */
	private static final int NUM_BACK = 1313;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */

	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector plusBTNSel = new ClassSelector(PLUS_BUTTON);
		Selector minusBTNSel = new ClassSelector(MINUS_BUTTON);
		Selector bckSelBTN = new ClassSelector(BACK_BUTTON);
		Selector hmSelBTN = new ClassSelector(HOME_BUTTON);
		Selector printBTNSel = new ClassSelector(PRINT_BUTTON);
		Selector countLBLSel = new ClassSelector(COUNT);
		Selector titleLBLSel = new ClassSelector(TITLE_LBL);
		Selector textLBLSel = new ClassSelector(TEXT_LBL);
		Selector canvasSel = new ClassSelector(CANVAS);
		Selector imagewidSel = new ClassSelector(NUM_BACK);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(plusBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(minusBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(bckSelBTN);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(hmSelBTN);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(printBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(titleLBLSel);
		style.setFont(font18);
		style.setColor(0x00CED1);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(textLBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(countLBLSel);
		style.setFont(font18);
		style.setColor(0x00CED1);
		style.setDimension(new FixedDimension(0, 0));

		style = stylesheet.getSelectorStyle(imagewidSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public static void Actions() {
		plusBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				if (cCopy <= 8) {
					cCopy++;
					countCopy.setText(Integer.toString(cCopy));
					countCopy.requestRender();
				} else {
					cCopy = 1;
					countCopy.setText(Integer.toString(cCopy));
					countCopy.requestRender();
				}
			}
		});
		minusBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				if (cCopy > 1 && cCopy < 10) {
					cCopy--;
					countCopy.setText(Integer.toString(cCopy));
					countCopy.requestRender();
				} else if (cCopy == 1) {
					cCopy = 9;
					countCopy.setText(Integer.toString(cCopy));
					countCopy.requestRender();
				}
			}
		});

		backBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Copy cType = new Copy();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				cType.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(cType.getContentWidget());
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

		printBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {

				CopyLoading load = new CopyLoading();
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
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen. Create a stylesheet and
	 * call the method to set the style of the widget. Call the method to set actions to the buttons.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {
		titleLBL = new Label(tltText);
		titleLBL.addClassSelector(TITLE_LBL);
		textLBL = new Label(txtText);
		textLBL.addClassSelector(TEXT_LBL);
		plusBTN = new ImageButton(PLUS);
		plusBTN.addClassSelector(PLUS_BUTTON);
		minusBTN = new ImageButton(MINUS);
		minusBTN.addClassSelector(MINUS_BUTTON);
		printBTN = new ImageButton(PRINT);
		printBTN.addClassSelector(PRINT_BUTTON);
		backBTN = new ImageButton(BACK);
		backBTN.addClassSelector(BACK_BUTTON);
		homeBTN = new ImageButton(HOME);
		homeBTN.addClassSelector(HOME_BUTTON);
		countCopy = new Label(Integer.toString(cCopy));
		countCopy.addClassSelector(COUNT);
		numberBack = new ImageWidget(NUM_IMG);
		numberBack.addClassSelector(NUM_BACK);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(titleLBL, 150, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL, 100, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(numberBack, 30, 150, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(countCopy, 70, 190, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(plusBTN, 140, 160, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(minusBTN, 140, 210, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(printBTN, 300, 150, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;
	}
}
