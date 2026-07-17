interface EnglishSpeaker {
    void speakEnglish();
}

class SpanishSpeaker {
    void speakSpanish() {
        System.out.println("Hola!");
    }
}

class TranslatorAdapter implements EnglishSpeaker {
    SpanishSpeaker speaker = new SpanishSpeaker();

    public void speakEnglish() {
        System.out.print("Translated: ");
        speaker.speakSpanish();
    }
}

public class AdapterExample6_Language {
    public static void main(String[] args) {
        EnglishSpeaker person = new TranslatorAdapter();
        person.speakEnglish();
    }
}