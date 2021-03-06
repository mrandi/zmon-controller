package de.zalando.zmon.domain;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.zalando.typemapper.annotations.DatabaseField;

import de.zalando.zmon.adapter.EntityListAdapter;
import de.zalando.zmon.annotation.ContainsEntityKey;
import de.zalando.zmon.annotation.NotNullEntity;

@XmlAccessorType(XmlAccessType.NONE)
public class CheckDefinitionImport {

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "name is mandatory")
    private String name;

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "description is mandatory")
    private String description;

    @XmlElement
    @DatabaseField
    private String technicalDetails;

    @XmlElement
    @DatabaseField
    private String potentialAnalysis;

    @XmlElement
    @DatabaseField
    private String potentialImpact;

    @XmlElement
    @DatabaseField
    private String potentialSolution;

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "owning team is mandatory")
    private String owningTeam;

    /* Map passing
     * JAXB also doesn't support Maps.  It handles Lists great, but Maps are
     * not supported directly. Use of a XmlAdapter to map the maps into beans that JAXB can use.
     */
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(EntityListAdapter.class)
    @DatabaseField
    @NotNullEntity(message = "null filters not supported")
    @ContainsEntityKey(message = "each entity should contain field: type", keys = {"type"})
    private List<Map<String, String>> entities;

    @XmlElement(required = true)
    @DatabaseField
    @Min(value = 1, message = "minimum interval value is 1")
    private Long interval;

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "command is mandatory")
    private String command;

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "status is mandatory")
    private DefinitionStatus status;

    @XmlElement
    @DatabaseField
    private String sourceUrl;

    @XmlElement(required = true)
    @DatabaseField
    @NotNull(message = "user that modified the check definition is mandatory")
    private String lastModifiedBy;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTechnicalDetails() {
        return technicalDetails;
    }

    public void setTechnicalDetails(final String technicalDetails) {
        this.technicalDetails = technicalDetails;
    }

    public String getPotentialAnalysis() {
        return potentialAnalysis;
    }

    public void setPotentialAnalysis(final String potentialAnalysis) {
        this.potentialAnalysis = potentialAnalysis;
    }

    public String getPotentialImpact() {
        return potentialImpact;
    }

    public void setPotentialImpact(final String potentialImpact) {
        this.potentialImpact = potentialImpact;
    }

    public String getPotentialSolution() {
        return potentialSolution;
    }

    public void setPotentialSolution(final String potentialSolution) {
        this.potentialSolution = potentialSolution;
    }

    public String getOwningTeam() {
        return owningTeam;
    }

    public void setOwningTeam(final String owningTeam) {
        this.owningTeam = owningTeam;
    }

    public List<Map<String, String>> getEntities() {
        return entities;
    }

    public void setEntities(final List<Map<String, String>> entities) {
        this.entities = entities;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(final Long interval) {
        this.interval = interval;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(final String command) {
        this.command = command;
    }

    public DefinitionStatus getStatus() {
        return status;
    }

    public void setStatus(final DefinitionStatus status) {
        this.status = status;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(final String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("CheckDefinitionImport [name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", technicalDetails=");
        builder.append(technicalDetails);
        builder.append(", potentialAnalysis=");
        builder.append(potentialAnalysis);
        builder.append(", potentialImpact=");
        builder.append(potentialImpact);
        builder.append(", potentialSolution=");
        builder.append(potentialSolution);
        builder.append(", owningTeam=");
        builder.append(owningTeam);
        builder.append(", entities=");
        builder.append(entities);
        builder.append(", interval=");
        builder.append(interval);
        builder.append(", command=");
        builder.append(command);
        builder.append(", status=");
        builder.append(status);
        builder.append(", sourceUrl=");
        builder.append(sourceUrl);
        builder.append(", lastModifiedBy=");
        builder.append(lastModifiedBy);
        builder.append("]");
        return builder.toString();
    }

}
