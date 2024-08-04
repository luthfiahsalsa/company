package com.project.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "riwayat_pelatihan")
public class RiwayatPelatihanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    @Column(name = "nama_pelatihan")
    private String nama_pelatihan;

    @Column(name = "sertifikat")
    private Boolean sertifikat;

    @Column(name = "tahun")
    private Integer tahun;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_biodata", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BiodataModel biodata;


}
