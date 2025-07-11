package said.team.lead.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequestDTO {
    private int ownerId;
    private List<OrderItemDto> items;

    public static class OrderItemDto {
        private int productId;
        private int quantity;
    }
}
