package kz.nikitka.rest.rest.api;

import kz.nikitka.rest.rest.dto.TyreDto;
import kz.nikitka.rest.rest.model.Tyre;
import kz.nikitka.rest.rest.service.TyreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tyre")
public class TyreController {

    private final TyreService tyreService;

    @GetMapping
    public List<TyreDto> getTyres(){
        return tyreService.getTyres();
    }

    @GetMapping(value = "{id}")
    public TyreDto getTyre(@PathVariable(name = "id") Long id){
        return tyreService.getTyre(id);
    }

    @PostMapping
    public TyreDto addTyre(@RequestBody TyreDto tyre){
        return tyreService.addTyre(tyre);
    }

    @PutMapping
    public TyreDto updateTyre(@RequestBody TyreDto tyre){
        return tyreService.updateTyre(tyre);
    }

    @DeleteMapping(value = "{id}")
    public void deleteTyre(@PathVariable(name = "id") Long id){
        tyreService.deleteTyre(id);
    }
}
