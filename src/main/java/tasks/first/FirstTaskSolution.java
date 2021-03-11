package tasks.first;

import java.util.*;

public class FirstTaskSolution implements FirstTask {
      @Override
      public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
            ArrayDeque<Integer> passedVerts = new ArrayDeque<>();
            String traveledVerts = "" + startIndex;
            passedVerts.add(startIndex);

            while (!passedVerts.isEmpty()) {
                  startIndex = passedVerts.getFirst();
                  passedVerts.removeFirst();

                  for (int i = 0; i < adjacencyMatrix.length; i++) {
                        if (!(traveledVerts.contains("" + i)) & adjacencyMatrix[startIndex][i]) {
                              passedVerts.addLast(i);
                              traveledVerts = traveledVerts + "," + i;
                        }
                  }
            }
            return traveledVerts;
      }

      @Override
      public Boolean validateBrackets(String s) {
            ArrayDeque<Character> arrayDequeOpenBrackets = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {

                  if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                        arrayDequeOpenBrackets.addLast(s.charAt(i));
                  } else {

                        if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                              if (arrayDequeOpenBrackets.size() > 0 && (arrayDequeOpenBrackets.peekLast() + 1 == s.charAt(i) || arrayDequeOpenBrackets.peekLast() + 2 == s.charAt(i))) {
                                    arrayDequeOpenBrackets.removeLast();
                              } else {
                                    return false;
                              }
                        }
                  }
            }

            return arrayDequeOpenBrackets.isEmpty();
      }

      @Override
      public Long polishCalculation(String s) {

            ArrayDeque<Long> numbers = new ArrayDeque<>();
            long number = 0;

            for (int i = 0; i < s.length(); i++) {
                  char charFromStr = s.charAt(i);

                  if (charFromStr > 47 && charFromStr < 58) {
                        number = number * 10 + Character.getNumericValue(charFromStr);
                  } else {

                        if (charFromStr == ' ') {
                              numbers.addLast(number);
                              number = 0;
                        } else {
                              long result;

                              switch (charFromStr) {
                                    case ('+'):
                                          result = numbers.removeLast() + numbers.removeLast();
                                          numbers.add(result);
                                          break;
                                    case ('-'):
                                          long temp1 = numbers.removeLast();
                                          result = numbers.removeLast() - temp1;
                                          numbers.add(result);
                                          break;
                                    case ('*'):
                                          result = numbers.removeLast() * numbers.removeLast();
                                          numbers.add(result);
                                          break;
                                    case ('/'):
                                          long temp2 = numbers.removeLast();
                                          result = numbers.removeLast() / temp2;
                                          numbers.add(result);
                                          break;
                              }
                              i++;

                        }
                  }
            }
            return numbers.peekLast();
      }
}
