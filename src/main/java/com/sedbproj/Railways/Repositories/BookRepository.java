package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    List <BookEntity> findBookEntitiesByUserIdOrderByRouteId(Integer userId);


    boolean existsBookEntityByRouteIdAndArriveStationIdAndDepartStationId1AndCarriageIdAndSeatNumAndSsn(
            Integer RouteId,
            Integer Arrive_StationId,
            Integer Depart_StationId1,
            Integer CarriageId,
            Integer SeatNumId,
            Long SSN
    );
    @Query(
            nativeQuery = true,
            value = "DELETE FROM Book " +
                    "WHERE RouteId=:routeID " +
                    "AND Depart_StationId1=:departStationID " +
                    "AND Arrive_StationId=:arriveStationID " +
                    "AND CarriageId=:carriageID " +
                    "AND SSN=:ssn " +
                    "AND SeatNum=:seatNum"
    )
    @Transactional
    @Modifying
    void deleteByCancelJson(
            @Param("routeID") Integer routeID,
            @Param("departStationID") Integer departStationID,
            @Param("arriveStationID") Integer arriveStationID,
            @Param("carriageID") Integer carriageID,
            @Param("seatNum") Integer seatNum,
            @Param("ssn") Integer ssn
    );

    List <BookEntity> findBookEntitiesByRouteIdAndCarriageId(Integer routeId, Integer carriageId);
}
