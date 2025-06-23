//Design principles & Patterns
//Exercise 2: Implementing the Factory Method Pattern

// File name: FactoryMethodPatternExample.java

// Step 1-2: Define a common interface for documents
interface Document {
    void open();
}

// Step 3: Implement concrete classes for each document type
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word Document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF Document.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel Document.");
    }
}

// Step 4: Define the abstract factory class
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// Step 4: Concrete factory classes
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Step 5: Test the Factory Method implementation
public class FactoryMethodPatternExample {
    public static void main(String[] args) {

        // Create Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        // Create PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        // Create Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}
