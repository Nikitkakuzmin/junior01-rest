package kz.nikitka.rest.rest.service;

import kz.nikitka.rest.rest.dto.TyreDto;
import kz.nikitka.rest.rest.mapper.TyreMapper;
import kz.nikitka.rest.rest.model.Tyre;
import kz.nikitka.rest.rest.repository.TyreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TyreService {

    private final TyreRepository tyreRepository;
    private final TyreMapper tyreMapper;

    public List<TyreDto> getTyres(){
        List<Tyre> tyres = tyreRepository.findAll();
        List<TyreDto> tyreDtoList = new ArrayList<>();
        tyres.forEach(tyre -> tyreDtoList.add(tyreMapper.toDto(tyre)));
//        for(Tyre tyre : tyres){
//            tyreDtoList.add(toDto(tyre));
//        }
        return tyreDtoList;
    }

    public TyreDto addTyre(TyreDto dto){
        Tyre tyre = tyreMapper.toEntity(dto);
        return tyreMapper.toDto(tyreRepository.save(tyre));
    }

    public TyreDto getTyre(Long id){
        return tyreMapper.toDto(tyreRepository.findById(id).orElseThrow());
    }

    public TyreDto updateTyre(TyreDto dto){
        return tyreMapper.toDto(tyreRepository.save(tyreMapper.toEntity(dto)));
    }

    public void deleteTyre(Long id){
        tyreRepository.deleteById(id);
    }
}