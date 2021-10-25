package com.example.seminar3;

import android.os.Parcel;
import android.os.Parcelable;

public class Persoana implements Parcelable {

    private String nume;
    private String prenume;
    private String email;
    private String dataNastere;

    public Persoana(String nume, String prenume, String email, String dataNastere) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.dataNastere = dataNastere;
    }

    public Persoana() {
    }

    protected Persoana(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        email = in.readString();
        dataNastere = in.readString();
    }

    public static final Creator<Persoana> CREATOR = new Creator<Persoana>() {
        @Override
        public Persoana createFromParcel(Parcel in) {
            return new Persoana(in);
        }

        @Override
        public Persoana[] newArray(int size) {
            return new Persoana[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persoana{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", prenume='").append(prenume).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", dataNastere='").append(dataNastere).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(email);
        dest.writeString(dataNastere);
    }
}
