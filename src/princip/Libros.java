/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package princip;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByIdLibro", query = "SELECT l FROM Libros l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libros.findByIlustrador", query = "SELECT l FROM Libros l WHERE l.ilustrador = :ilustrador"),
    @NamedQuery(name = "Libros.findByNumPaginas", query = "SELECT l FROM Libros l WHERE l.numPaginas = :numPaginas"),
    @NamedQuery(name = "Libros.findByFirmado", query = "SELECT l FROM Libros l WHERE l.firmado = :firmado"),
    @NamedQuery(name = "Libros.findByIsbn", query = "SELECT l FROM Libros l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libros.findByPrecio", query = "SELECT l FROM Libros l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libros.findByPortada", query = "SELECT l FROM Libros l WHERE l.portada = :portada"),
    @NamedQuery(name = "Libros.findByFechPrimPublic", query = "SELECT l FROM Libros l WHERE l.fechPrimPublic = :fechPrimPublic"),
    @NamedQuery(name = "Libros.findByValoracion", query = "SELECT l FROM Libros l WHERE l.valoracion = :valoracion")})
public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Libro")
    private String idLibro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "ilustrador")
    private String ilustrador;
    @Column(name = "numPaginas")
    private Integer numPaginas;
    @Lob
    @Column(name = "sipnosis")
    private String sipnosis;
    @Column(name = "firmado")
    private Boolean firmado;
    @Column(name = "ISBN")
    private String isbn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "portada")
    private String portada;
    @Column(name = "fech_prim_public")
    @Temporal(TemporalType.DATE)
    private Date fechPrimPublic;
    @Column(name = "valoracion")
    private Short valoracion;
    @JoinColumn(name = "id_Genero", referencedColumnName = "id_Genero")
    @ManyToOne
    private Genero idGenero;
    @JoinColumn(name = "id_Editorial", referencedColumnName = "id_Editorial")
    @ManyToOne
    private Editorial idEditorial;

    public Libros() {
    }

    public Libros(String idLibro) {
        this.idLibro = idLibro;
    }

    public Libros(String idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public Boolean getFirmado() {
        return firmado;
    }

    public void setFirmado(Boolean firmado) {
        this.firmado = firmado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Date getFechPrimPublic() {
        return fechPrimPublic;
    }

    public void setFechPrimPublic(Date fechPrimPublic) {
        this.fechPrimPublic = fechPrimPublic;
    }

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "princip.Libros[ idLibro=" + idLibro + " ]";
    }
    
}
