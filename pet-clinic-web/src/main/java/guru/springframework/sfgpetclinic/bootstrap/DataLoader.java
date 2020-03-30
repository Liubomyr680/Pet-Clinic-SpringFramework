package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Liubomyr");
        owner1.setLastName("Shynkaruk");
        owner1.setAddress("Nezalegnosti st.");
        owner1.setCity("Ivano-Frankivsk");
        owner1.setTelephone("0500131110");

        Pet liubomyrPet = new Pet();
        liubomyrPet.setPetType(saveDog);
        liubomyrPet.setOwner(owner1);
        liubomyrPet.setBirthDate(LocalDate.now());
        liubomyrPet.setName("Rondo");
        owner1.getPets().add(liubomyrPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Lirnik");
        owner2.setAddress("Vidkryta st.");
        owner2.setCity("Kyiv");
        owner2.setTelephone("978342352");

        Pet antonPet = new Pet();
        antonPet.setPetType(saveCat);
        antonPet.setOwner(owner2);
        antonPet.setBirthDate(LocalDate.now());
        antonPet.setName("Baloon");
        owner2.getPets().add(antonPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kristina");
        vet1.setLastName("Shynkaruk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Brightstone");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");

    }
}
