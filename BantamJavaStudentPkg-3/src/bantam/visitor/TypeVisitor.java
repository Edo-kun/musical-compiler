package bantam.visitor;

/**
 * Make sure types are valid and annotates the ast nodes
 * key things to check
 * (1) score name is a string
 * (2) variables are assigned phrase expressions
 * (3) loops are given a positive int to loop
 * (4) octave modifiers are within range
 * (5) instrument declarations are valid instruments
 * (6) volume is within 1-11
 * (7) _ are padded correctly
 * (8) block stmts have valid expressions to match
 */
public class TypeVisitor extends MusicVisitor {
}
