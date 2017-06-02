/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.IllegalStateException;

/**
 *
 * @author Rohit Tirmanwar
 * @param <F> Generic type for the first element of the Pair
 * @param <S> Generic type for the second element of the Pair
 */
public class Pair<F, S> {

    // Overview: Pair is a mutable generic class consisting of a pair of two different elements
    // A typical Pair has two elements, either of the same or different types(F and S)
    // Rep Invarient (r): first and second element of the pair are different, i.e. firstElement != secondElement
    // AF(r): Pair of any two types (r.firstElement, r.secondElement)
    // Instance variables
    private F firstElement;
    private S secondElement;

    // Constructors
    /**
     * Parameterized constructor initializes this object with pair of given
     * elements
     *
     * @param first element of the pair
     * @param second element of the pair
     */
    Pair(F first, S second) {
        // Modifies: this
        // Effects: Initializes this object with two elements provided

        this.firstElement = first;
        this.secondElement = second;
    }

    // Methods
    /**
     * Gets the first element of the pair
     *
     * @return first element of the pair
     */
    public F getFirstElement() {
        // Effects: returns the first element of the pair

        return this.firstElement;
    }

    /**
     * Gets the second element of the pair
     *
     * @return second element of the pair
     */
    public S getSecondElement() {
        // Effects: returns the second element of the pair

        return this.secondElement;
    }

    /**
     * Modifies the first element of this pair
     *
     * @param first element of the pair to replace with
     * @throws IllegalStateException if the state of this object becomes invalid
     */
    public void setFirstElement(F first) {
        // Modifies: this
        // Effects: sets the given element as the first object of this Pair

        this.firstElement = first;

        if (!repOK()) {
            throw new IllegalStateException("Invalid rep invarient");
        }
    }

    /**
     * Modifies the second element of this pair
     *
     * @param second element of the pair to replace with
     * @throws IllegalStateException if the state of this object becomes invalid
     */
    public void setSecondElement(S second) {
        // Modifies: this
        // Effects: sets the given element as the second object of this Pair

        this.secondElement = second;

        if (!repOK()) {
            throw new IllegalStateException("Invalid rep invarient");
        }
    }

    /**
     * Override method the string form of this pair object
     *
     * @return the string form of this pair object
     */
    @Override
    public String toString() {
        // Effects: returns string form of this Pair

        return new String(("Pair[" + this.firstElement.toString() + ", " + this.secondElement.toString() + "]"));
    }

    /**
     * Override method returns if two pairs are equal or not For more
     * information on this, please refer to the equals method of object class in
     * javadoc https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
     *
     * @param obj to compare this pair with
     * @return true of this pair and obj are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        // Effects: returns true, if this and obj are equal, else returns false

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair objPair = (Pair) obj;
        return (objPair.firstElement.equals(this.firstElement) && objPair.secondElement.equals(this.secondElement));
    }

    /**
     * Generates and returns the hashcode of this pair
     *
     * @return the hashcode of this pair
     */
    @Override
    public int hashCode() {
        // Effects: returns hashcode of this Pair object

        int result = 17;
        result = 31 * result + this.firstElement.hashCode();
        result = 31 * result + this.secondElement.hashCode();
        return result;
    }

    /**
     * Checks the validity of this Pair object
     *
     * @return true if this pair is valid, otherwise returns false
     */
    private boolean repOK() {
        // Effects: returns true if rep invarient of this pair is valid, otherwise returns false

        if (this.firstElement.equals(this.secondElement)) {
            return false;
        }
        return true;
    }

}
