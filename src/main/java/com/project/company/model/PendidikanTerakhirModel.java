package com.project.company.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pendidikan_terakhir")
public class PendidikanTerakhirModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "jenjang")
    private String jenjang;

    @Size(max = 150)
    @Column(name = "nama_institusi")
    private String nama_institusi;

    @Size(max = 200)
    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "tahun_lulus")
    private Integer tahun_lulus;

    @Column(name = "ipk")
    private Double ipk;

    @OneToOne(mappedBy = "pendidikan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BiodataModel biodata;

}
