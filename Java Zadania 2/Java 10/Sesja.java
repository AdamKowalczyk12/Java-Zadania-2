public class Sesja {
    private String[] egzaminy;
    private int zdane;
    private int niezdane;
    private int pozostale;
    private String[] terminy;

    public Sesja(String[] egzaminy, String[] terminy) {
        this.egzaminy = egzaminy;
        this.terminy = terminy;
        this.zdane = 0;
        this.niezdane = 0;
        this.pozostale = egzaminy.length;
    }

    public boolean Egzamin(String przedmiot) {
        int indexEgzaminu = -1;
        for (int i = 0; i < egzaminy.length; i++) {
            if (przedmiot.equals(egzaminy[i])) {
                indexEgzaminu = i;
                break;
            }
        }
        if (indexEgzaminu == -1)
            return false;

        String dataEgzaminu = terminy[indexEgzaminu];
        boolean czyZdany = true;
        for (int i = 0; i < terminy.length; i++) {
            if (dataEgzaminu.equals(terminy[i]) && i != indexEgzaminu)
                czyZdany = false;
        }

        if (czyZdany)
            zdane++;
        else
            niezdane++;
        pozostale--;

        return czyZdany;
    }

    public boolean CzySesjaOk() {
        int liczbaStyczen = 0;
        for (int i = 0; i < terminy.length; i++) {
            String[] data = terminy[i].split("-");
            if (data[1].equals("01") || data[1].equals("02"))
                liczbaStyczen++;
        }
        if (liczbaStyczen < 2)
            return false;

        if (pozostale > 10)
            return false;

        for (int i = 0; i < terminy.length; i++) {
            int liczbaDlaDanegoDnia = 0;
            for (int j = 0; j < terminy.length; j++) {
                if (terminy[i].equals(terminy[j]))
                    liczbaDlaDanegoDnia++;
            }
            if (liczbaDlaDanegoDnia > 1)
                return false;
        }
        return true;
    }
}
