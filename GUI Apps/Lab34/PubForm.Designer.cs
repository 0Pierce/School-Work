namespace Lab34
{
    partial class PubForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnPubl = new System.Windows.Forms.Button();
            this.btnExitP = new System.Windows.Forms.Button();
            this.lblContent = new System.Windows.Forms.Label();
            this.txtbContent = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnPubl
            // 
            this.btnPubl.Location = new System.Drawing.Point(23, 120);
            this.btnPubl.Name = "btnPubl";
            this.btnPubl.Size = new System.Drawing.Size(134, 43);
            this.btnPubl.TabIndex = 0;
            this.btnPubl.Text = "Publish";
            this.btnPubl.UseVisualStyleBackColor = true;
            this.btnPubl.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnPubl_MouseClick);
            // 
            // btnExitP
            // 
            this.btnExitP.Location = new System.Drawing.Point(228, 120);
            this.btnExitP.Name = "btnExitP";
            this.btnExitP.Size = new System.Drawing.Size(134, 43);
            this.btnExitP.TabIndex = 1;
            this.btnExitP.Text = "Exit";
            this.btnExitP.UseVisualStyleBackColor = true;
            this.btnExitP.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btnExitP_MouseClick);
            // 
            // lblContent
            // 
            this.lblContent.AutoSize = true;
            this.lblContent.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblContent.Location = new System.Drawing.Point(19, 28);
            this.lblContent.Name = "lblContent";
            this.lblContent.Size = new System.Drawing.Size(153, 20);
            this.lblContent.TabIndex = 2;
            this.lblContent.Text = "Notification Content:";
            // 
            // txtbContent
            // 
            this.txtbContent.Location = new System.Drawing.Point(188, 27);
            this.txtbContent.Name = "txtbContent";
            this.txtbContent.Size = new System.Drawing.Size(174, 20);
            this.txtbContent.TabIndex = 3;
            // 
            // PubForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(418, 186);
            this.Controls.Add(this.txtbContent);
            this.Controls.Add(this.lblContent);
            this.Controls.Add(this.btnExitP);
            this.Controls.Add(this.btnPubl);
            this.Name = "PubForm";
            this.Text = "Publish";
            this.Load += new System.EventHandler(this.PubForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnPubl;
        private System.Windows.Forms.Button btnExitP;
        private System.Windows.Forms.Label lblContent;
        private System.Windows.Forms.TextBox txtbContent;
    }
}