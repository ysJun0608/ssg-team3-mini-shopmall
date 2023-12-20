//package book_pocket.entity;
//
//import book_pocket.dto.ShippingInfo;
//
//import java.util.List;
//
//public class Order {
//    private List<OrderLine> orderLines;
//    private Money totalAmounts;
//
//
//    public void changeShipped() {}
//    public void changeShippingInfo(ShippingInfo newShipping) {}
//    public void cancelOrder() {}
//    public void completePayment() {}
//
//    private void verifyAtLestOneOrMoreorderLines(List<OrderLine> orderLines) {
//        if (orderLines == null || orderLines.isEmpty()) {
//            throw new IllegalStateException("no OrderLine");
//        }
//    }
//
//    private void calculateTotalAmounts() {
//        int sum = orderLines.stream().mapToInt(x -> x.getAmounts()).sum();
//        this.totalAmounts = new Money(sum);
//    }
//}
