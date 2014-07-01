package txa.game;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class AdvString {
	private static final String BUNDLE_NAME = "txa.game.lang"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private AdvString() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
