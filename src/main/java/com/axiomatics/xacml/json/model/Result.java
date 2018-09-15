package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * An authorization decision result
 * <p>
 * It MAY include a set of obligations that MUST be fulfilled by the PEP.  If the PEP does not understand or cannot fulfill an obligation,
 * then the action of the PEP is determined by its bias.
 * It MAY include a set of advice with supplemental information which MAY be safely ignored by the PEP.
 */
@Data
@ApiModel("An authorization decision result")
public class Result {

    @ApiModelProperty(value = "The authorization decision", allowableValues = "Permit, Deny, Indeterminate, NotApplicable")
    @JsonProperty("Decision")
    PDPDecision decision;

    @ApiModelProperty(notes = "Indicates whether errors occurred during evaluation of the decision request, and optionally, information about those errors.")
    @JsonProperty("Status")
    Status status;

    @ApiModelProperty(notes = "A list of advice that provide supplemental information to the PEP.\n" +
        "If the PEP does not understand an advice, the PEP may safely ignore the advice. ")
    @JsonProperty("Obligations")
    List<ObligationOrAdvice> associatedAdvice;

    @ApiModelProperty(notes = "A list of obligations that MUST be fulfilled by the PEP.\n" +
        "If the PEP does not understand or cannot fulfill an obligation, then the action of the PEP is determined by its bias.")
    @JsonProperty("AssociatedAdvice")
    List<ObligationOrAdvice> obligations;

    @ApiModelProperty(notes = "A list of attributes that were part of the request. The choice of which attributes are included here is made with the " +
        "IncludeInResult attribute of the <Attribute> elements of the request")
    @JsonProperty("Category")
    List<Category> categories;

    @ApiModelProperty(notes = "Object containing lists of policy and policy set IdReferences which have been applicable to a request.\n" +
        "If the ReturnPolicyIdList attribute in the Request is true , a PDP that implements this optional feature MUST return a " +
        "list of all policies which were found to be fully applicable.")
    @JsonProperty("PolicyIdentifierList")
    PolicyIdentifierList policyIdentifierList;
}
