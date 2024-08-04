package com.project.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="biodata")
public class BiodataModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama")
    private String nama;

    @NotNull
    @Size(max=16)
    @Column(name = "no_ktp")
    private String no_ktp;

    @NotNull
    @Size(max=100)
    @Column(name = "tempat_lahir")
    private String tempat_lahir;

    @NotNull
    @Column(name = "tanggal_lahir")
    private Date tanggal_lahir;

    @NotNull
    @Size(max = 20)
    @Column(name = "jenis_kelamin")
    private String jenis_kelamin;

    @NotNull
    @Size(max=50)
    @Column(name = "agama")
    private String agama;

    @NotNull
    @Size(max=50)
    @Column(name = "status")
    private String status;

    @NotNull
    @Size(max=255)
    @Column(name = "alamat_ktp")
    private String alamat_ktp;

    @NotNull
    @Size(max=255)
    @Column(name = "alamat_tinggal")
    private String alamat_tinggal;

    @NotNull
    @Size(max=15)
    @Column(name = "no_telp")
    private String no_telp;

    @NotNull
    @Size(max=15)
    @Column(name = "emergency_call")
    private String emergency_call;

    @NotNull
    @Size(max=255)
    @Column(name = "skill")
    private String skill;

    @NotNull
    @Column(name = "bersedia_ditempatkan")
    private Boolean bersedia_ditempatkan;

    @NotNull
    @Column(name = "ekspektasi_penghasilan")
    private Long ekspektasi_penghasilan;

//    @OneToOne(mappedBy = "biodata", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private UserModel user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pendidikan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PendidikanTerakhirModel pendidikan;

    @OneToMany(mappedBy = "biodata", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<RiwayatPelatihanModel> listPelatihan;

    @OneToMany(mappedBy = "biodata", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<PekerjaanModel> listPekerjaan;
}
