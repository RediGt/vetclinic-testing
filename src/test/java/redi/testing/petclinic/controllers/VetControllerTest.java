package redi.testing.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redi.testing.petclinic.ControllerTests;
import redi.testing.petclinic.fauxspring.Model;
import redi.testing.petclinic.fauxspring.ModelMapImpl;
import redi.testing.petclinic.model.Vet;
import redi.testing.petclinic.services.SpecialtyService;
import redi.testing.petclinic.services.VetService;
import redi.testing.petclinic.services.map.SpecialityMapService;
import redi.testing.petclinic.services.map.VetMapService;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//@Tag("controllers")
class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setup() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "john", "stone", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertThat("vets/index").isEqualTo(view);
        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }

}