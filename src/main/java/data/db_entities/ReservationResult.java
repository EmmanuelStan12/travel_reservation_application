package data.db_entities;

import java.util.List;

public class ReservationResult {

    private Integer nextPage;

    private Integer start;

    private Long end;

    private Integer pageSize;

    private List<Trip> trips;

    private Long count;

    private Detail detail;

    private Long pages;

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPages() {
        return pages;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getEnd() {
        return end;
    }

    public Integer getStart() {
        return start;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public ReservationResult(Integer page, Integer perPage, List<Trip> trips, Long count) {
        this.nextPage = page;
        this.pageSize = perPage;
        this.trips = trips;
        this.count = count;
    }

    public ReservationResult() {
    }

    @Override
    public String toString() {
        return "ReservationResult{" +
                "nextPage=" + nextPage +
                ", start=" + start +
                ", end=" + end +
                ", pageSize=" + pageSize +
                ", trips=" + trips +
                ", count=" + count +
                ", detail=" + detail +
                ", pages=" + pages +
                '}';
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
