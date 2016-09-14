package it.albertus.jface.listener;

import it.albertus.util.Configured;

/** Accepts only float inputs and trims automatically. */
public class FloatVerifyListener extends NumberVerifyListener {

	public FloatVerifyListener(final Configured<Boolean> allowNegatives) {
		super(allowNegatives);
	}

	public FloatVerifyListener(final boolean allowNegatives) {
		this(new Configured<Boolean>() {
			@Override
			public Boolean getValue() {
				return allowNegatives;
			}
		});
	}

	@Override
	protected boolean isNumeric(final String string) {
		try {
			Float.parseFloat(string);
			return true;
		}
		catch (final Exception e) {
			if (".".equals(string) || "e".equalsIgnoreCase(string) || (allowNegatives.getValue() && "-".equals(string))) {
				return true;
			}
			return false;
		}
	}

}