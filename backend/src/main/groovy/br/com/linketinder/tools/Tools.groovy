package br.com.linketinder.tools

class Tools {

    Scanner scanner = new Scanner(System.in)

    String entradaDados() {
        return scanner.nextLine()
    }

    List<String> splitAndTrim(List<String> input) {
        input.collectMany {it.split(',').collect { it.trim() }}
    }
}
