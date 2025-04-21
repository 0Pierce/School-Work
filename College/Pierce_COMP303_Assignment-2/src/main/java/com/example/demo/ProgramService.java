package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    // Get all programs
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    // Get a program by ID (not used in your current example, assuming you need programCode)
    public Program getProgramById(Long programCode) {
        Optional<Program> program = programRepository.findById(programCode);
        return program.orElse(null);
    }

    // Get a program by programCode
    public Program getProgramByProgramCode(int programCode) {
        return programRepository.findByProgramCode(programCode); // Assuming you have a method for this in ProgramRepository
    }

    // Save a program (for example, if you need to add new programs)
    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    // Other methods as needed
}
