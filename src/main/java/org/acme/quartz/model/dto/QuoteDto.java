package org.acme.quartz.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuoteDto {
        private Double c; // current price
        private Double d; // change
        private Double dp; // percent change
        private Double h; // high price of the day
        private Double l; // low price of the day
        private Double o; // open price of the day
        private Double pc; // previous close price
    }
