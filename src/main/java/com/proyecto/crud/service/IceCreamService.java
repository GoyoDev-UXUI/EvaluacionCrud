package com.proyecto.crud.service;

import com.proyecto.crud.model.IceCream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IceCreamService {

    private List<IceCream> iceCreams = new ArrayList<>();
    private Long nextId = 1L;

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }

    public Optional<IceCream> getIceCreamById(Long id) {
        return iceCreams.stream().filter(iceCream -> iceCream.getId().equals(id)).findFirst();
    }

    public IceCream createIceCream(IceCream iceCream) {
        iceCream.setId(nextId++);
        iceCreams.add(iceCream);
        return iceCream;
    }

    public Optional<IceCream> updateIceCream(Long id, IceCream iceCreamDetails) {
        return getIceCreamById(id).map(iceCream -> {
            iceCream.setName(iceCreamDetails.getName());
            iceCream.setFlavor(iceCreamDetails.getFlavor());
            iceCream.setType(iceCreamDetails.getType());
            return iceCream;
        });
    }

    public boolean deleteIceCream(Long id) {
        return iceCreams.removeIf(iceCream -> iceCream.getId().equals(id));
    }
}
