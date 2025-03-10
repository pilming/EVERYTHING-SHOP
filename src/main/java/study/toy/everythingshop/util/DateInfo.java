package study.toy.everythingshop.util;

import study.toy.everythingshop.dto.PointHistoryDTO;
import study.toy.everythingshop.dto.SalesSummaryDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateInfo {

    //날짜 유효성 검사
    private final LocalDate fromLocalDate;
    private final LocalDate endLocalDate;

    public static String DATE_PATTERN = "yyyy-MM-dd";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public DateInfo(PointHistoryDTO pointHistoryDTO) {
        this.fromLocalDate = convertToLocalDate(pointHistoryDTO.getFromDate());
        this.endLocalDate = convertToLocalDate(pointHistoryDTO.getEndDate());
    }

    public DateInfo(SalesSummaryDTO salesSummaryDTO) {
        this.fromLocalDate = convertToLocalDate(salesSummaryDTO.getFromDate());
        this.endLocalDate = convertToLocalDate(salesSummaryDTO.getEndDate());
    }

    public String getEarlyDate() {
        //종료날짜가 시작날짜보다 빠르다면 두 값 스왑
        if(endLocalDate == null || fromLocalDate == null) return null;

        if (endLocalDate.isBefore(fromLocalDate)) {
            return endLocalDate.format(formatter);
        }
        return fromLocalDate.format(formatter);

    }

    public String getLateDate() {
        //종료날짜가 시작날짜보다 빠르다면 두 값 스왑
        if(endLocalDate == null || fromLocalDate == null) return null;

        if (fromLocalDate.isAfter(endLocalDate)) {
            return fromLocalDate.format(formatter);
        }
        return endLocalDate.format(formatter);
    }

    public LocalDate convertToLocalDate(String date){
        if(date != null) return LocalDate.parse(date);
        else return null;
    }

}
