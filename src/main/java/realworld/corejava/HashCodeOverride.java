package realworld.corejava;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: blueaken
 * Date: 1/14/16 8:19 AM
 */
public class HashCodeOverride {
    private String symbol;
    private String exchange;
    private long lotSize;
    private int tickSize;
    private boolean isRestricted;
    private Date settlementDate;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeOverride that = (HashCodeOverride) o;

        if (lotSize != that.lotSize) return false;
        if (tickSize != that.tickSize) return false;
        if (isRestricted != that.isRestricted) return false;
        if (!symbol.equals(that.symbol)) return false;
        if (!exchange.equals(that.exchange)) return false;
        if (!settlementDate.equals(that.settlementDate)) return false;
        return price.equals(that.price);

    }

    @Override
    public int hashCode() {
        int result = symbol.hashCode();
        result = 31 * result + exchange.hashCode();
        result = 31 * result + (int) (lotSize ^ (lotSize >>> 32));
        result = 31 * result + tickSize;
        result = 31 * result + (isRestricted ? 1 : 0);
        result = 31 * result + settlementDate.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
