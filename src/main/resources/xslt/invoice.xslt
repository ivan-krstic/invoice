<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:template match="*">
		<Invoice>
			<Number><xsl:value-of select="/invoice/number" /></Number>
			<InvoiceDate><xsl:value-of select="/invoice/invoiceDate" /></InvoiceDate>
			<TotalWithoutTax><xsl:value-of select="/invoice/totalWithoutTax" /></TotalWithoutTax>
			<Tax><xsl:value-of select="/invoice/tax" /></Tax>
			<Total><xsl:value-of select="/invoice/total" /></Total>
			<Owner>
				<Name><xsl:value-of select="/invoice/owner/name" /></Name>
				<ZipCode><xsl:value-of select="/invoice/owner/zipCode" /></ZipCode>
				<City><xsl:value-of select="/invoice/owner/city" /></City>
				<Street><xsl:value-of select="/invoice/owner/street" /></Street>
				<HouseNumber><xsl:value-of select="/invoice/owner/houseNumber" /></HouseNumber>
				<Email><xsl:value-of select="/invoice/owner/email" /></Email>
				<Phone><xsl:value-of select="/invoice/owner/phone" /></Phone>
				<BankAccount><xsl:value-of select="/invoice/owner/bankAccount" /></BankAccount>
				<BankName><xsl:value-of select="/invoice/owner/bankName" /></BankName>
				<TaxNumber><xsl:value-of select="/invoice/owner/taxNumber" /></TaxNumber>
			</Owner>
			<Client>
				<Name><xsl:value-of select="/invoice/client/name" /></Name>
				<ZipCode><xsl:value-of select="/invoice/client/zipCode" /></ZipCode>
				<City><xsl:value-of select="/invoice/client/city" /></City>
				<Street><xsl:value-of select="/invoice/client/street" /></Street>
				<HouseNumber><xsl:value-of select="/invoice/client/houseNumber" /></HouseNumber>
				<Email><xsl:value-of select="/invoice/client/email" /></Email>
				<Phone><xsl:value-of select="/invoice/client/phone" /></Phone>
				<BankAccount><xsl:value-of select="/invoice/client/bankAccount" /></BankAccount>
				<BankName><xsl:value-of select="/invoice/client/bankName" /></BankName>
				<TaxNumber><xsl:value-of select="/invoice/client/taxNumber" /></TaxNumber>
			</Client>
			<InvoiceItems>
				<xsl:for-each select="/invoice/invoiceItems">
					<InvoiceItem>
						<Service><xsl:value-of select="service/name" /></Service>
						<Measurement><xsl:value-of select="service/measurement/name" /></Measurement>
						<Quantity><xsl:value-of select="quantity" /></Quantity>
						<Price><xsl:value-of select="service/price" /></Price>
						<Total><xsl:value-of select="total" /></Total>
					</InvoiceItem>
				</xsl:for-each>
			</InvoiceItems>
		</Invoice>
	</xsl:template>
</xsl:stylesheet>