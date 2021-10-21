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
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;
import mainprinter.Main;

/**
 * The Class Copy, a class which create a widget that you can choice a type of copy that you want, if it's colorful or
 * black and white.
 */
public class Copy {

	/** The off color BTN. */
	static ImageButton offcolorBTN;

	/** The color BTN. */
	static ImageButton colorBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The copy LBL. */
	static Label copyLBL;

	/** The text LBL. */
	static Label textLBL;

	/** The id. */
	private static int ID = 0;

	/** The Constant COPYTITLE. */
	private static final String COPYTITLE = "COPY"; //$NON-NLS-1$

	/** The Constant COPYTEXT. */
	private static final String COPYTEXT = "What kind of copy do you need?"; //$NON-NLS-1$

	/** The Constant BW_BUTTON. */
	private static final int BW_BUTTON = 10;

	/** The Constant CLR_BUTTON. */
	private static final int CLR_BUTTON = 11;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 12;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 13;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 14;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 15;

	/** The Constant CANVAS. */
	private static final int CANVAS = 16;

	/** The Constant OFFCOLORBUTTON. */
	private static final String OFFCOLORBUTTON = "/images/copybw.png"; //$NON-NLS-1$

	/** The Constant COLORBUTTON. */
	private static final String COLORBUTTON = "/images/copycolor.png"; //$NON-NLS-1$

	/** The Constant HOME. */
	private static final String HOME = "/images/home.png"; //$NON-NLS-1$

	/** The Constant BACK. */
	private static final String BACK = "/images/home_seta.png"; //$NON-NLS-1$

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between.
	 * the screens.
	 */
	public static void Actions() {
		offcolorBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				CopyOption cOption = new CopyOption();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				cOption.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(cOption.getContentWidget());
				d.requestShow();
			}
		});

		colorBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				CopyOption cOption = new CopyOption();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				cOption.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(cOption.getContentWidget());
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
					CopyFinishing cFin = new CopyFinishing();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					cFin.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(cFin.getContentWidget());
					d.requestShow();
				}
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
	 *
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector bwPBtnSel = new ClassSelector(BW_BUTTON);
		Selector clrPBtnSel = new ClassSelector(CLR_BUTTON);
		Selector hmPBtnSel = new ClassSelector(HOME_BUTTON);
		Selector bckPBtnSel = new ClassSelector(BACK_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(bwPBtnSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(clrPBtnSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(hmPBtnSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(bckPBtnSel);
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

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen. Create a stylesheet and
	 * call the method to set the style of the widget. Call the method to set actions to the buttons.
	 *
	 * @return ContentWidget
	 *
	 */
	public Widget getContentWidget() {
		offcolorBTN = new ImageButton(OFFCOLORBUTTON);
		offcolorBTN.addClassSelector(BW_BUTTON);
		colorBTN = new ImageButton(COLORBUTTON);
		colorBTN.addClassSelector(CLR_BUTTON);
		homeBTN = new ImageButton(HOME);
		homeBTN.addClassSelector(HOME_BUTTON);
		backBTN = new ImageButton(BACK);
		backBTN.addClassSelector(BACK_BUTTON);
		copyLBL = new Label(COPYTITLE);
		copyLBL.addClassSelector(TITLE_LABEL);
		textLBL = new Label(COPYTEXT);
		textLBL.addClassSelector(TEXT_LABEL);

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(copyLBL, 220, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(textLBL, 120, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(offcolorBTN, 50, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(colorBTN, 250, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);

		return cv;

	}

	/**
	 * Gets the iD of the selected screen.
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
