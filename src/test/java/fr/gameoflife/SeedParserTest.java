package fr.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeedParserTest {

    @Test
    void when_given_non_existing_file_seed_should_raise_an_error() {
        assertThrows(IllegalArgumentException.class, ()->SeedParser.ParseForSeed("MissingFile.txt"));
    }


    @Test
    void when_parsing_file_should_return_correct_grid_dimensions(){
        var gridStats = SeedParser.ParseForSeed("seedTest.txt");
        assertEquals(4, gridStats.length);
        assertEquals(20, gridStats[0][0]);
        assertEquals(18, gridStats[0][1]);
    }

    @Test
    void when_parsing_file_should_return_correct_values(){
        var gridStats = SeedParser.ParseForSeed("seedTest.txt");
        assertEquals(12, gridStats[1][0]);
        assertEquals(13, gridStats[1][1]);
        assertEquals(1, gridStats[2][0]);
        assertEquals(1, gridStats[2][1]);
        assertEquals(10, gridStats[3][0]);
        assertEquals(10, gridStats[3][1]);
    }

}