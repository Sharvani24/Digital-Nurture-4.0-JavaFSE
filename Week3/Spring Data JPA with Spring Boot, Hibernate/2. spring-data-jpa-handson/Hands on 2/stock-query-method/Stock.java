package com.cognizant.ormlearn.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stId;

    @Column(name = "st_code", length = 10)
    private String stCode;

    @Column(name = "st_date")
    private LocalDate stDate;

    @Column(name = "st_open", precision = 10, scale = 2)
    private BigDecimal stOpen;

    @Column(name = "st_close", precision = 10, scale = 2)
    private BigDecimal stClose;

    @Column(name = "st_volume")
    private Long stVolume;

    public Integer getStId() { return stId; }
    public void setStId(Integer stId) { this.stId = stId; }

    public String getStCode() { return stCode; }
    public void setStCode(String stCode) { this.stCode = stCode; }

    public LocalDate getStDate() { return stDate; }
    public void setStDate(LocalDate stDate) { this.stDate = stDate; }

    public BigDecimal getStOpen() { return stOpen; }
    public void setStOpen(BigDecimal stOpen) { this.stOpen = stOpen; }

    public BigDecimal getStClose() { return stClose; }
    public void setStClose(BigDecimal stClose) { this.stClose = stClose; }

    public Long getStVolume() { return stVolume; }
    public void setStVolume(Long stVolume) { this.stVolume = stVolume; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s → %s | vol=%d",
            stCode,
            stDate,
            stOpen,
            stClose,
            stVolume
        );
    }
}
