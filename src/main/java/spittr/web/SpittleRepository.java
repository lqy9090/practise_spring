package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.List;

@Component
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
