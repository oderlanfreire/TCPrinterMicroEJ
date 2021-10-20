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
import ej.widget.basic.ImageWidget;
import ej.widget.basic.Label;
import ej.widget.basic.OnClickListener;
import ej.widget.container.Canvas;
import mainprinter.Main;

/**
 * The Class PrintUSB. Declaration of attributes, Strings content and the ID's for class selectors
 */
public class PrintUSB {

	/** The home. */
	static ImageButton home;

	/** The back. */
	static ImageButton back;

	/** The content. */
	static ImageButton content;

	/** The title. */
	static Label title;

	/** The text. */
	static Label text;

	/** The background file. */
	static ImageWidget backgroundFile;

	/** The title STR. */
	private final String titleSTR = "PRINT FROM USB"; //$NON-NLS-1$

	/** The text STR. */
	private final String textSTR = "Please, select a file to print:"; //$NON-NLS-1$

	/** The Constant backFile. */
	private static final String backFile = "/images/retangulo.png";//$NON-NLS-1$

	/** The Constant CONTENT. */
	private static final String CONTENT = "/images/printbutton.png"; //$NON-NLS-1$

	/** The Constant BACK. */
	private static final String BACK = "/images/home_seta.png"; //$NON-NLS-1$

	/** The Constant HOME. */
	private static final String HOME = "/images/home.png"; //$NON-NLS-1$

	/** The Constant CONTENT_BUTTON. */
	private static final int CONTENT_BUTTON = 60;

	/** The Constant BACK_BUTTON. */
	private static final int BACK_BUTTON = 61;

	/** The Constant HOME_BUTTON. */
	private static final int HOME_BUTTON = 62;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 63;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 64;

	/** The Constant CANVAS. */
	private static final int CANVAS = 65;

	/** The Constant IMAGEWIDGET. */
	private static final int IMAGEWIDGET = 66;

	/**
	 * This method to populate the style of components in the screen receiving a CascadingStylesheet. Use selector to
	 * get the class attributes that will receive a style by ID using ClassSelector. Use EditableStylesheet to set style
	 * in the attributes.
	 *
	 * @param stylesheet
	 *            the Cascading Stylesheet.
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector contentBTNSel = new ClassSelector(CONTENT_BUTTON);
		Selector backBTNSel = new ClassSelector(BACK_BUTTON);
		Selector homeBTNSel = new ClassSelector(HOME_BUTTON);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);
		Selector imagewidSel = new ClassSelector(IMAGEWIDGET);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(contentBTNSel);
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
		content.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				PrintType pType = new PrintType();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				pType.populateStylesheet(stylesheet);
				pType.setID(2);
				d.setStylesheet(stylesheet);
				d.setWidget(pType.getContentWidget());
				d.requestShow();
			}
		});
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				Printer print = new Printer();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				print.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(print.getContentWidget());
				d.requestRender();
				d.requestShow();
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
				d.requestRender();
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
		content = new ImageButton(CONTENT);
		content.addClassSelector(CONTENT_BUTTON);
		back = new ImageButton(BACK);
		back.addClassSelector(BACK_BUTTON);
		home = new ImageButton(HOME);
		home.addClassSelector(HOME_BUTTON);
		title = new Label(this.titleSTR);
		title.addClassSelector(TITLE_LABEL);
		text = new Label(this.textSTR);
		text.addClassSelector(TEXT_LABEL);
		backgroundFile = new ImageWidget(backFile);
		backgroundFile.addClassSelector(IMAGEWIDGET);

		CascadingStylesheet stylesheet = new CascadingStylesheet();
		populateStylesheet(stylesheet);

		Actions();

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);

		cv.addChild(back, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(title, 120, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(home, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text, 100, 50, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(backgroundFile, 50, 130, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(content, 70, 150, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;
	}
}
