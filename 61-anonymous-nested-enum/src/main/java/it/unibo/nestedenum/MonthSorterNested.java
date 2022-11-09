package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                final var m1 = Month.fromString(arg0);
                final var m2 = Month.fromString(arg1);
                return Integer.compare(m1.days, m2.days);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                return Month.fromString(arg0).compareTo(Month.fromString(arg1));
            }
        };
    }

    private enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        public static Month fromString(final String name) {
            try {
                return valueOf(name);
            } catch (IllegalArgumentException e) {
                Month match = null;
                for (Month month : values()) {
                    if (month.toString().toLowerCase().startsWith(name.toLowerCase())) {
                        if (match == null) {
                            match = month;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                if (match == null) {
                    throw new IllegalArgumentException();
                } else {
                    return match;
                }
            }
        }
    }
}
