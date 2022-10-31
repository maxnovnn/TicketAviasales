package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    static TicketRepository repo = new TicketRepository();
    static TicketManager manager = new TicketManager(repo);
    private static final String LED = "Пулково";
    private static final String KZN = "Казань";
    private static final String SVO = "Шереметьево";
    private static final String VKO = "Внуково";
    private static final String LA = "LA";

    static Ticket first = new Ticket(1, 6287, LED, KZN, 133);
    static Ticket second = new Ticket(2, 1299, SVO, KZN, 95);
    static Ticket third = new Ticket(3, 3899, VKO, KZN, 95);
    static Ticket fourth = new Ticket(4, 110, LA, KZN, 1200);


    @BeforeAll
    static void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
    }

    @Test
    public void shouldFindAll() {
        Ticket[] expected = {fourth};
        assertArrayEquals(expected, manager.findAll(LA, KZN));
    }

    @Test
    public void shouldShowAllOffers() {
        Ticket[] expected = {fourth, second, third, first};
        assertArrayEquals(expected, manager.findAllOffers());
    }

    @Test
    public void shouldSortByPrice() {
        Ticket[] expected = {fourth, second, third, first};
        Ticket[] actual = {fourth, second, third, first};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}