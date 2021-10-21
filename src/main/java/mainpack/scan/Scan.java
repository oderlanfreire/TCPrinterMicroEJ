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
 * The Class Scan, a class which creates a widget that you can choice a type of scan, if was a document or a photo.
 */
public class Scan {

	/** The document BTN. */
	static ImageButton documentBTN;

	/** The photo BTN. */
	static ImageButton photoBTN;

	/** The back BTN. */
	static ImageButton backBTN;

	/** The home BTN. */
	static ImageButton homeBTN;

	/** The title. */
	static Label title;

	/** The text. */
	static Label text;

	/** The id. */
	private static int ID = 0;

	/** The title STR. */
	private final String titleSTR = "SCAN"; //$NON-NLS-1$

	/** The text STR. */
	private final String textSTR = "What kind of scan do you need?"; //$NON-NLS-1$

	/** The Constant DOCUMENT_ImageButton. */
	private static final int DOCUMENT_ImageButton = 333;

	/** The Constant PHOTO_ImageButton. */
	private static final int PHOTO_ImageButton = 334;

	/** The Constant BACK_ImageButton. */
	private static final int BACK_ImageButton = 335;

	/** The Constant HOME_ImageButton. */
	private static final int HOME_ImageButton = 336;

	/** The Constant TITLE_LABEL. */
	private static final int TITLE_LABEL = 337;

	/** The Constant TEXT_LABEL. */
	private static final int TEXT_LABEL = 338;

	/** The Constant CANVAS. */
	private static final int CANVAS = 339;

	/**
	 * This method set a onClickListener to the ImageButtons attributing actions to them. Make the navigation between
	 * the screens.
	 */
	public static void Actions() {
		documentBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanDoc doc = new ScanDoc();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				doc.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(doc.getContentWidget());
				d.requestShow();
			}
		});

		photoBTN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				ScanPhoto photo = new ScanPhoto();
				Desktop d = new Desktop();
				CascadingStylesheet stylesheet = new CascadingStylesheet();
				photo.populateStylesheet(stylesheet);
				d.setStylesheet(stylesheet);
				d.setWidget(photo.getContentWidget());
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
					ScanFinish sFin = new ScanFinish();
					Desktop d = new Desktop();
					CascadingStylesheet stylesheet = new CascadingStylesheet();
					sFin.populateStylesheet(stylesheet);
					d.setStylesheet(stylesheet);
					d.setWidget(sFin.getContentWidget());
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
	 */
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		Selector docBTNSel = new ClassSelector(DOCUMENT_ImageButton);
		Selector photoBTNSel = new ClassSelector(PHOTO_ImageButton);
		Selector backBTNSel = new ClassSelector(BACK_ImageButton);
		Selector homeBTNSel = new ClassSelector(HOME_ImageButton);
		Selector titleLBLSel = new ClassSelector(TITLE_LABEL);
		Selector textLBLSel = new ClassSelector(TEXT_LABEL);
		Selector canvasSel = new ClassSelector(CANVAS);

		Font font18 = Font.getFont("/Fonts/ARIAL_BOLD_18PX.ejf"); //$NON-NLS-1$
		Font font14 = Font.getFont("/Fonts/ARIAL_BOLD_14PX.ejf"); //$NON-NLS-1$

		EditableStyle style = stylesheet.getSelectorStyle(docBTNSel);
		style.setDimension(new FixedDimension(0, 0));
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(photoBTNSel);
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
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(textLBLSel);
		style.setFont(font14);
		style.setColor(Colors.BLACK);
		style.setBackground(new RectangularBackground(0xE5E5E0));

		style = stylesheet.getSelectorStyle(canvasSel);
		style.setBackground(new RectangularBackground(0xE5E5E0));
	}

	/**
	 * Get the contentWidget. Where the the attributes are instantiated and sets in the screen. Create a stylesheet and
	 * call the method to set the style of the widget. Call the method to set actions to the buttons.
	 *
	 * @return ContentWidget
	 */
	public Widget getContentWidget() {

		documentBTN = new ImageButton("/images/DOCUMENT.png"); //$NON-NLS-1$
		documentBTN.addClassSelector(DOCUMENT_ImageButton);
		photoBTN = new ImageButton("/images/PHOTO.png"); //$NON-NLS-1$
		photoBTN.addClassSelector(PHOTO_ImageButton);
		backBTN = new ImageButton("/images/home_seta.png"); //$NON-NLS-1$
		backBTN.addClassSelector(BACK_ImageButton);
		homeBTN = new ImageButton("/images/home.png"); //$NON-NLS-1$
		homeBTN.addClassSelector(HOME_ImageButton);
		title = new Label(this.titleSTR);
		title.addClassSelector(TITLE_LABEL);
		text = new Label(this.textSTR);
		text.addClassSelector(TEXT_LABEL);

		Canvas cv = new Canvas();
		cv.addClassSelector(CANVAS);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		populateStylesheet(stylesheet);

		Actions();

		cv.addChild(backBTN, 10, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(title, 190, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(homeBTN, 435, 10, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(text, 100, 40, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(documentBTN, 70, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		cv.addChild(photoBTN, 240, 120, Widget.NO_CONSTRAINT, Widget.NO_CONSTRAINT);
		return cv;

	}

	/**
	 * Gets the iD of the selected class.
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
