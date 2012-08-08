package com.byclosure.opensource.client.util;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>TextTrimmer class.</p>
 *
 * @author Manuel Cajada
 */
public class TextTrimmer {

	public static void trim(final HasText widget) {
		((Widget) widget).addAttachHandler(new AttachEvent.Handler() {
			public void onAttachOrDetach(AttachEvent event) {
				trim0(widget);
			}
		});
	}

	private static void trim0(HasText widget) {
		int widgetHeight = ((Widget) widget).getOffsetHeight();
		int parentHeight = ((Widget) widget).getParent().getOffsetHeight();

		if (widgetHeight > parentHeight) {
			String text = widget.getText();
			widget.setText(text.replaceFirst("\\W*\\s(\\S)*$/?", "..."));
			trim0(widget);
		}
	}
}
