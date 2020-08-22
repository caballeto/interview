package hackerrank.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Command example:
//
// CREATE: id=1&amount=100&currency=USD
// FINALIZE: id=1&amount=100
// PAY: id=1
public class _stripe_prev {
  private static final String CURRENCY_PARAMETER = "currency=";
  private static final String AMOUNT_PARAMETER = "amount=";
  private static final String ID_PARAMETER = "id=";
  
  private enum Status {
    CREATED,
    FINALIZED,
    PAYED
  }
  
  private static class Invoice {
    int id;
    int amount;
    String currency;
    Status status;
    
    public Invoice(int id, int amount, String currency) {
      this.id = id;
      this.amount = amount;
      this.currency = currency;
    }
  }
  
  public static int calculate_total_owed(List<String> actions) {
    Map<Integer, Invoice> invoices = new HashMap<>();
    
    for (String action : actions) {
      if (action.startsWith("CREATE: ")) {
        Invoice invoice = parseInvoice(action);
        invoice.status = Status.CREATED;
        if (!invoices.containsKey(invoice.id))
          invoices.put(invoice.id, invoice);
      } else if (action.startsWith("FINALIZE: ")) {
        Invoice invoice = parseInvoice(action);
        
        if (invoices.containsKey(invoice.id) && invoices.get(invoice.id).status == Status.CREATED) {
          Invoice finalized = invoices.get(invoice.id);
          finalized.amount = invoice.amount;
          finalized.status = Status.FINALIZED;
        }
      } else if (action.startsWith("PAY: ")) {
        int id = parseIntegerParameter(action, ID_PARAMETER);
        if (invoices.containsKey(id) && invoices.get(id).status == Status.FINALIZED) {
          invoices.get(id).status = Status.PAYED;
        }
      }
    }
    
    int total = 0;
    
    for (Invoice invoice : invoices.values()) {
      if (invoice.status != Status.PAYED && invoice.currency.equals("USD")) {
        total += invoice.amount;
      }
    }
    
    return total;
  }
  
  private static Invoice parseInvoice(String action) {
    int id = parseIntegerParameter(action, ID_PARAMETER);
    int amount = parseIntegerParameter(action, AMOUNT_PARAMETER);
    String currency = parseCurrency(action);
    return new Invoice(id, amount, currency);
  }
  
  private static String parseCurrency(String action) {
    int index = action.indexOf(CURRENCY_PARAMETER);
    return action.substring(index + CURRENCY_PARAMETER.length());
  }
  
  private static int parseIntegerParameter(String action, String name) {
    int index = action.indexOf(name) + name.length();
    int num = 0;
    while (index < action.length() && Character.isDigit(action.charAt(index)))
      num = num * 10 + (action.charAt(index++) - '0');
    return num;
  }
  
  public static void main(String[] args) {
    //System.out.println(parseIntegerParameter("CREATE: id=13&amount=800&currency=USD", "amount="));
  }
}
