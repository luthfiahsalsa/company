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
@Table(name = "pekerjaan")
public class PekerjaanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 200)
    @Column(name = "nama_perusahaan")
    private String nama_perusahaan;

    @Size(max = 100)
    @Column(name = "posisi_terakhir")
    private String posisi_terakhir;

    @Column(name = "pendapatan_terakhir")
    private Long pendapatan_terakhir;

    @Column(name = "tahun")
    private Integer tahun;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_biodata", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BiodataModel biodata;

}
