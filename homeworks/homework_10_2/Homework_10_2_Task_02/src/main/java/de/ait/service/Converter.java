package de.ait.service;

import de.ait.model.Conversion;

public interface Converter {
    Conversion convert(String from, String to, double amount);
}
