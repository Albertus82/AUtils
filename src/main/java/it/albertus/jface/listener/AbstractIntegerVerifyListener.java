package it.albertus.jface.listener;

import it.albertus.util.Configured;

abstract class AbstractIntegerVerifyListener<T extends Number> extends AbstractNumberVerifyListener<T> {

	public AbstractIntegerVerifyListener(final boolean allowNegatives) {
		super(allowNegatives);
	}

	public AbstractIntegerVerifyListener(final Configured<Boolean> allowNegatives) {
		super(allowNegatives);
	}

	@Override
	protected boolean isNumeric(final String string) {
		if (string != null) {
			try {
				parseNumber(string);
				return true;
			}
			catch (final NumberFormatException nfe) {
				if (allowNegatives.getValue() && "-".equals(string)) {
					return true;
				}
			}
		}
		return false;
	}

}
